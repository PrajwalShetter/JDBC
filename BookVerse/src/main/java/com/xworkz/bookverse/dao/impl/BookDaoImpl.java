package com.xworkz.bookverse.dao.impl;

import com.mysql.cj.jdbc.Driver;
import com.xworkz.bookverse.dao.BookDao;
import com.xworkz.bookverse.dto.BookDto;

import javax.xml.stream.events.StartElement;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Class.forName;

public class BookDaoImpl implements BookDao {

    String url = "jdbc:mysql://localhost:3306/BookVerse";
    String user = "root";
    String password ="Pajju#123";

    @Override
    public void save(BookDto book) {
        System.out.println("DAO save method invoked");

        Statement statement = null;
        Connection connection = null;
        try{

            forName("com.mysql.cj.jdbc.Driver");

             connection = DriverManager.getConnection(url,user,password);
            System.out.println("Database Connected");

             statement = connection.createStatement();
            String sql = "INSERT INTO book (title, author, price, category, publisher) VALUES ('"
            + book.getTitle() + "','"
            + book.getAuthor() +"',"
            + book.getPrice() + ",'"
            + book.getCategory() +"','"
            + book.getPublisher()+"')";


            System.out.println(sql);
            statement.execute(sql);
            System.out.println("data inserted");

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
                try{
                    if(statement != null){
                        statement.close();
                    }
                    if(connection != null){
                        connection.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }

    }

    @Override
    public List<BookDto> getAllData() {

        System.out.println("DAO getAllData() invoked");
        List<BookDto> list = new ArrayList<>();
        Connection connection = null;
        Statement statement =null;
        ResultSet resultSet = null;
        try{

            forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
            String sql = "SELECT * FROM book";

            statement= connection.createStatement();
             resultSet =statement.executeQuery(sql);

             while (resultSet.next()){

            BookDto dto = new BookDto();

            dto.setTitle(resultSet.getString("title"));
                 dto.setAuthor(resultSet.getString("author"));
                 dto.setPrice(resultSet.getDouble("price"));
                 dto.setCategory(resultSet.getString("category"));
                 dto.setPublisher(resultSet.getString("publisher"));

                 list.add(dto);
             }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(connection != null){
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public List<BookDto> getDataById(int id) {
        List<BookDto> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
            String sql = "SELECT * FROM book where id= ?";

             statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();

            while (resultSet.next()){

                BookDto dto = new BookDto();

                dto.setTitle(resultSet.getString("title"));
                dto.setAuthor(resultSet.getString("author"));
                dto.setPrice(resultSet.getDouble("price"));
                dto.setCategory(resultSet.getString("category"));
                dto.setPublisher(resultSet.getString("publisher"));

                list.add(dto);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(connection != null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }


}
