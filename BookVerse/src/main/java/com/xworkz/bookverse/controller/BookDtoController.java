package com.xworkz.bookverse.controller;

import com.xworkz.bookverse.dto.BookDto;
import com.xworkz.bookverse.service.BookDtoService;
import com.xworkz.bookverse.service.impl.BookDtoServiceImpl;

import java.util.List;

public class BookDtoController {

BookDtoService service = new BookDtoServiceImpl();

    public void save(BookDto book){
        System.out.println("Controller Save() invoked");
        service.save(book);

    }

   public List<BookDto> getAllData(){
        return service.getAllData();
    }

    public List<BookDto> getDataById(int id){
        return service.getDataById(id);
    }

}
