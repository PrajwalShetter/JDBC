package com.xworkz.bookverse.service.impl;

import com.xworkz.bookverse.dao.BookDao;
import com.xworkz.bookverse.dao.impl.BookDaoImpl;
import com.xworkz.bookverse.dto.BookDto;
import com.xworkz.bookverse.service.BookDtoService;

import java.util.Collections;
import java.util.List;

public class BookDtoServiceImpl implements BookDtoService {

    BookDao dao = new BookDaoImpl();
    @Override
    public void save(BookDto book){

        System.out.println("Services Save() invoked");
        boolean isTitle = false;
        boolean isAuthor = false;
        boolean isPrice = false;
        boolean isCategory = false;
        boolean isPublisher = false;

        if (book != null){

            if(book.getTitle() != null && book.getTitle().matches("^[a-zA-Z ]{3,16}$")){

                isTitle = true;
            }
            if(book.getAuthor() != null && book.getAuthor().matches("^[a-zA-Z ]{3,16}$")){
                isAuthor =true;
            }
            if(book.getPrice() > 0 ){
                isPrice = true;
            }
            if(book.getCategory() != null && book.getCategory().matches("^[a-zA-Z ]{3,16}$")){
                isCategory = true;

            }
            if(book.getPublisher() != null && book.getPublisher().matches("^[a-zA-Z ]{3,16}$")){
                isPublisher = true;
            }
        }
        else{
            System.out.println("Book object is null");
            return;
        }

        System.out.println("isTitle :"+isTitle);
        System.out.println("isAuthor :"+isAuthor);
        System.out.println("isPrice :"+isPrice);
        System.out.println("isCategory :"+isCategory);
        System.out.println("isPublisher :"+isPublisher);

        if(isTitle && isAuthor && isPrice && isCategory && isPublisher){
            System.out.println("All Validations are Passed");
            dao.save(book);

        }
        else{
            System.out.println("Validations are failed");
        }

    }

    @Override
    public List<BookDto> getAllData() {
        return dao.getAllData();
    }

    @Override
    public List<BookDto> getDataById(int id) {
        return dao.getDataById(id);
    }
}
