package com.example.example.model;

import jakarta.persistence.*;

@Table(name = "books")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int Book_id;

    @Column(name="Book_Name", nullable = false)
    private String Book_Name;

    @Column(name="Book_Author", nullable = false)
    private String Book_Author;

    @Column(name="Stored_date", nullable = false)
    private int Stored_date;

    public int getBook_id() {
        return Book_id;
    }

    public void setBook_id(int book_id) {
        Book_id = book_id;
    }

    public String getBook_Name() {
        return Book_Name;
    }

    public void setBook_Name(String book_Name) {
        Book_Name = book_Name;
    }

    public String getBook_Author() {
        return Book_Author;
    }

    public void setBook_Author(String book_Author) {
        Book_Author = book_Author;
    }

    public int getStored_date() {
        return Stored_date;
    }

    public void setStored_date(int stored_date) {
        Stored_date = stored_date;
    }
}

