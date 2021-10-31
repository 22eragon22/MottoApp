package com.example.motto_app.Objects;

public class MottoContent {
    private Integer id;
    private String content;

    public MottoContent(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
}
