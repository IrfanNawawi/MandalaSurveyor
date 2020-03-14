package com.mandala.surveyor.data.items;

public class BottomMenu {
    private int image;
    private int badge;
    private String title;

    public BottomMenu(int image, int badge, String title) {
        this.image = image;
        this.badge = badge;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public int getBadge() {
        return badge;
    }

    public String getTitle() {
        return title;
    }
}
