package com.library.springbootlibrary.responsemodels;

import lombok.Data;

@Data
public class AddBookRequest {

    private String title;
    private String author;
    private String suthor;
    private String description;
    private String category;
    private int copies;
    private String img;
    
}