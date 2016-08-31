package com.example.treinamento_xiaomi.launcher.model;

/**
 * Created by Lincoln on 18/05/16.
 */
public class News {
    private String title;
    private int picture;

    public News() {
    }

    public News(String title, int picture) {
        this.title = title;
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

}
