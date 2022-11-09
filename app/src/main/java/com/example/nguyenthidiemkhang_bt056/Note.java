package com.example.nguyenthidiemkhang_bt056;

public class Note {
    int id;
    String title;
    String date;
    String content;

    public Note(int id, String title, String date, String content) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
