package com.momento.app.data;
public class story {
    private int id;
    private String userName;
    private int storyImage;

    public story(int id, String userName, int storyImage) {
        this.id = id;
        this.userName = userName;
        this.storyImage = storyImage;
    }

    public story() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStoryImage() {
        return storyImage;
    }

    public void setStoryImage(int storyImage) {
        this.storyImage = storyImage;
    }

}
