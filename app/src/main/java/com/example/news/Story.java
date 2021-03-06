package com.example.news;

import android.media.Image;

import java.io.Serializable;

public class Story implements Serializable {

    private int id;
    private String imageName;
    private String title;
    private String content;
    private String shortContent;

    public Story(int id, String imageName, String title, String content, String shortContent) {
        this.id = id;
        this.imageName = imageName;
        this.title = title;
        this.content = content;
        this.shortContent = shortContent;
    }

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

    public String getShortContent() { return shortContent; }

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

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }
}
