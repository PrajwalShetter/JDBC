package com.xworkz.bookverse.runner;

import com.xworkz.bookverse.controller.BookDtoController;
import com.xworkz.bookverse.dto.BookDto;

import java.util.List;

public class BookDtoRunner {

    public static void main(String[] args) {

//        BookDto book = new BookDto();
//        book.setTitle("Heli hogu karana");
//        book.setAuthor("Ravi beligeri");
//        book.setPrice(300.00);
//        book.setCategory("Love story");
//        book.setPublisher("smilyBooks");

//        BookDto book = new BookDto();
//        book.setTitle("Cyber Security");
//        book.setAuthor("Prajwal");
//        book.setPrice(3000.00);
//        book.setCategory("Technology");
//        book.setPublisher("Cyber Center");
//
        BookDtoController controller = new BookDtoController();
//        controller.save(book);


        List<BookDto> list = controller.getAllData();

        for( BookDto dto :list){


            System.out.println(dto.getTitle());
            System.out.println(dto.getAuthor());
            System.out.println(dto.getCategory());
            System.out.println(dto.getPrice());
            System.out.println(dto.getPublisher());

            System.out.println("----------------------");
        }

        List<BookDto> list2 = controller.getDataById(2);

        for( BookDto dto :list2){


            System.out.println(dto.getTitle());
            System.out.println(dto.getAuthor());
            System.out.println(dto.getCategory());
            System.out.println(dto.getPrice());
            System.out.println(dto.getPublisher());

            System.out.println("----------------------");
        }

    }
}
