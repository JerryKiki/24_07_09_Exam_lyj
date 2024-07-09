package org.koreait.motivation.entity;

public class Motivation {

    private int id;
    private String regDate;
    private String content;
    private String author;

    public Motivation(int id, String regDate, String content, String author) {
        this.id = id;
        this.regDate = regDate;
        this.content = content;
        this.author = author;
    }
}
