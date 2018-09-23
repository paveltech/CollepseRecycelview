package com.example.dream71.collepserecycelview;

public class Pojo {

    public String title;
    public String details;

    public Pojo(String title , String details){
        this.title = title;
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public String getTitle() {
        return title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
