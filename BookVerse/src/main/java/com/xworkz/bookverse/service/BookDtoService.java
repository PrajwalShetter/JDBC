package com.xworkz.bookverse.service;

import com.xworkz.bookverse.dto.BookDto;

import java.util.List;

public interface BookDtoService {

void save(BookDto book);

List<BookDto> getAllData();

List<BookDto> getDataById(int id);

}
