package com.example.safeguide1;


public class txtItems_facilities {
    private String text;
    private int imageResourceId;

    public txtItems_facilities(String text, int imageResourceId) {
        this.text = text;
        this.imageResourceId = imageResourceId;
    }

    public String getText() {
        return text;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}