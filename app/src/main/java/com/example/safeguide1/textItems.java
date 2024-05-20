package com.example.safeguide1;


    public class textItems {
        private String text;
        private int imageResourceId;

        public textItems(String text, int imageResourceId) {
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