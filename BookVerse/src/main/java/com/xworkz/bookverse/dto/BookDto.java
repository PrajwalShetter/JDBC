package com.xworkz.bookverse.dto;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class BookDto {

    private String title ;
    private String author;
    private double price;
    private String category;
    private String publisher;

}
