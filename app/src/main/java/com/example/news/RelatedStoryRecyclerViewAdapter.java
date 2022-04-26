package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RelatedStoryRecyclerViewAdapter extends RecyclerView.Adapter<RelatedStoryRecyclerViewAdapter.ViewHolder> {

    private List<Story> storyList;
    private Context context;

    public RelatedStoryRecyclerViewAdapter(List<Story> storyList, Context context) {
        this.storyList = storyList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.related_story_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Story story = storyList.get(position);
        int resourceId = context.getResources().getIdentifier(story.getImageName(), "drawable",
                context.getPackageName());
        holder.imageViewStory.setImageResource(resourceId);
        holder.textViewTitle.setText(story.getTitle());
        holder.textViewContent.setText(story.getShortContent());
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewStory;
        TextView textViewTitle;
        TextView textViewContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewStory = itemView.findViewById(R.id.imageViewRelatedStory);
            textViewTitle = itemView.findViewById(R.id.textViewRelatedStoryTitle);
            textViewContent = itemView.findViewById(R.id.textViewRelatedStoryContent);
        }
    }
}
