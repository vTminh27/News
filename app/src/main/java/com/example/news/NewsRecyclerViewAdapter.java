package com.example.news;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder> {

    private List<Story> storyList;
    private Context context;

    public NewsRecyclerViewAdapter(List<Story> storyList, Context context) {
        this.storyList = storyList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.news_row, parent, false);
        return new NewsRecyclerViewAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRecyclerViewAdapter.ViewHolder holder, int position) {
        Story story = storyList.get(position);
        int resourceId = context.getResources().getIdentifier(story.getImageName(), "drawable",
                context.getPackageName());
        holder.imageViewNews.setImageResource(resourceId);
        holder.textViewTitle.setText(story.getTitle());
        holder.textViewContent.setText(story.getShortContent());
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewNews;
        TextView textViewTitle;
        TextView textViewContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewNews = itemView.findViewById(R.id.imageViewNewsImage);
            textViewTitle = itemView.findViewById(R.id.textViewNewsTitle);
            textViewContent = itemView.findViewById(R.id.textViewNewsShortContent);
        }
    }
}

