package com.xworkz.bookverse.dao;

import com.xworkz.bookverse.dto.BookDto;

import java.util.List;

public interface BookDao {

    void save(BookDto book);

    List<BookDto> getAllData();

    List<BookDto> getDataById(int id);
 }
