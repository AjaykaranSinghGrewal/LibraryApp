package com.library.springbootlibrary.responsemodels;

import com.library.springbootlibrary.entity.Book;
import lombok.Data;

//this class will create an object of class Book & how many days are left to return the book & then return the object
@Data
public class ShelfCurrentLoansResponse {
    
    private Book book;
    private int daysLeft;

    public ShelfCurrentLoansResponse(Book book, int daysLeft) {
        this.book = book;
        this.daysLeft = daysLeft;
    }
}
