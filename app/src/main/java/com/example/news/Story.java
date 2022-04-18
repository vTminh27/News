package com.example.news;

import android.media.Image;

public class Story {

    private int id;
    private String imageName;
    private String title;
    private String content;

    public Story(int id, String imageName, String title, String content) {
        this.id = id;
        this.imageName = imageName;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getImageName() {
        return imageName;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
