package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewTopStories;
    RecyclerViewAdapter recyclerViewTopStoriesAdapter;

    RecyclerView recyclerViewNews;
    RecyclerViewAdapter recyclerViewNewsAdapter;

    List<Story> topStoryList = new ArrayList<>();
    List<Story> newsList = new ArrayList<>();

    String[] imageNames = {"ankara", "antalya", "efes", "eskisehir", "patara"};
    String[] squareImageNames = {"square_ankara", "square_antalya", "square_efes", "square_eskisehir", "square_patara"};
    String[] titles = {"Ankara", "Antalya", "Efes", "Eskisehir", "Patara"};
    String[] content = {
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < imageNames.length; i++) {
            Story story = new Story(i, squareImageNames[i], titles[i], content[i]);
            Story news = new Story(i, imageNames[i], titles[i], content[i]);
            topStoryList.add(story);
            newsList.add(news);
        }

        // Top Stories
        recyclerViewTopStories = findViewById(R.id.recyclerStories);
        recyclerViewTopStoriesAdapter = new RecyclerViewAdapter(topStoryList, this);
        recyclerViewTopStories.setAdapter(recyclerViewTopStoriesAdapter);

        LinearLayoutManager topLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewTopStories.setLayoutManager(topLayoutManager);

        // News
        recyclerViewNews = findViewById(R.id.recyclerNews);
        recyclerViewNewsAdapter = new RecyclerViewAdapter(newsList, this);
        recyclerViewNews.setAdapter(recyclerViewNewsAdapter);

        LinearLayoutManager newsLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewNews.setLayoutManager(newsLayoutManager);
    }

    public void prevClick(View view) {
        recyclerViewTopStories.getLayoutManager().scrollToPosition(0);
    }
    public void nextClick(View view) {
        recyclerViewTopStories.getLayoutManager().scrollToPosition(squareImageNames.length - 1);
    }
}