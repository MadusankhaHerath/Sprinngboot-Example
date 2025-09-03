package com.example.example.dto;

public class BookCreateDTO {

    public int Book_ID;
    public String Book_Name;
    public String Book_Author;
    public int Stored_date;

    public BookCreateDTO() {
    }
    public BookCreateDTO(int Book_ID, String Book_Name, String Book_Author,int Stored_date) {
        this.Book_ID = Book_ID;
        this.Book_Name = Book_Name;
        this.Book_Author = Book_Author;
        this.Stored_date = Stored_date;
    }

    public int getStored_date() {
        return Stored_date;
    }

    public void setStored_date(int stored_date) {
        Stored_date = stored_date;
    }

    public String getBook_Author() {
        return Book_Author;
    }

    public void setBook_Author(String book_Author) {
        Book_Author = book_Author;
    }

    public String getBook_Name() {
        return Book_Name;
    }

    public void setBook_Name(String book_Name) {
        Book_Name = book_Name;
    }

    public int getBook_ID() {
        return Book_ID;
    }

    public void setBook_ID(int book_ID) {
        Book_ID = book_ID;
    }
}
