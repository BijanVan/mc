package com.mastercard.solution4;

public class Book {
  private String title;
  private String isbn;
  private String[] authors;

  public Book(String title, String[] authors, String isbn) {
    this.title = title;
    this.authors = authors;
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String[] getAuthors() {
    return authors;
  }

  public void setAuthors(String[] authors) {
    this.authors = authors;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
}
