package com.example.news;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String SELECTED_STORY = "SELECTED_STORY";
    private static final String RELATED_STORIES = "RELATED_STORIES";

    // TODO: Rename and change types of parameters
    private Story story;
    private List<Story> relatedStories;

    ImageView imageView;
    TextView textViewTitle;
    TextView textViewContent;

    RecyclerView recyclerView;
    RelatedStoryRecyclerViewAdapter recyclerViewAdapter;

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(Story aStory, List<Story> relatedStories) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(SELECTED_STORY, aStory);
        args.putSerializable(RELATED_STORIES, (Serializable) relatedStories);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            story = (Story) getArguments().getSerializable(SELECTED_STORY);
            relatedStories = (List<Story>) getArguments().getSerializable(RELATED_STORIES);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = view.findViewById(R.id.imageView);
        textViewTitle = view.findViewById(R.id.textViewTitle);
        textViewContent = view.findViewById(R.id.textViewContent);

        textViewTitle.setText(story.getTitle());
        textViewContent.setText(story.getContent());

        int resourceId = getActivity().getResources().getIdentifier(story.getImageName(), "drawable",
                getActivity().getPackageName());
        imageView.setImageResource(resourceId);

        recyclerView = view.findViewById(R.id.recyclerViewRelatedStories);
        recyclerViewAdapter = new RelatedStoryRecyclerViewAdapter(relatedStories, view.getContext());
        recyclerView.setAdapter(recyclerViewAdapter);

        LinearLayoutManager newsLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(newsLayoutManager);
    }
}