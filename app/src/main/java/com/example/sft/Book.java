package com.example.sft;

public class Book {
  String title;
  String author;
  String content;

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
    //커스텀뷰에는 title과 author만 들어가고 메모는 안 들어간다.
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

}
