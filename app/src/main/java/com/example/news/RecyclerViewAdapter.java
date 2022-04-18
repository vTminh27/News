package com.example.news;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Story> storyList;
    private Context context;

    public RecyclerViewAdapter(List<Story> storyList, Context context) {
        this.storyList = storyList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.top_story_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Story story = storyList.get(position);
        int resourceId = context.getResources().getIdentifier(story.getImageName(), "drawable",
                context.getPackageName());
        holder.imageViewStory.setImageResource(resourceId);
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewStory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewStory = itemView.findViewById(R.id.imagViewStory);
        }
    }
}
