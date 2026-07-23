package com.xworkz.BankApplication.Dao.impl;

import com.xworkz.BankApplication.Dao.BankDao;
import com.xworkz.BankApplication.Dto.UserDto;
import com.xworkz.BankApplication.constant.AccountType;

import java.sql.*;
import java.util.*;

import static java.lang.Class.forName;


public class BankDaoImpl implements BankDao {

    String url ="jdbc:mysql://localhost:3306/bank_db";
    String user = "root";
    String password = "Pajju#123";


    @Override
    public void register(UserDto users) {
        Connection connection = null;
        Statement statement = null;

        if(users != null){
            try{
                forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,user,password);
                System.out.println("Database connected");

                String sql = "INSERT INTO user(name, age, dob, gmail, address, mobile_no, nomineeName, balance, account_type) VALUES ("
                        + "'" + users.getName() + "', "
                        + users.getAge() + ", "
                        + "'" + users.getDob() + "', "
                        + "'" + users.getGmail() + "', "
                        + "'" + users.getAddress() + "', "
                        + "'" + users.getMobileNo() + "', "
                        + "'" + users.getNomineeName() + "', "
                        + users.getBalance() + ", "
                        + "'" + users.getAccountType().name() + "'"
                        + ")";

                statement = connection.createStatement();
                statement.execute(sql);
                System.out.println("data inserted succesfully");


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
    }


    @Override
    public void getDetailsByEmail(String gmail) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if(gmail != null){
            try{
                forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(url,user,password);

                String sql = "SELECT * FROM user WHERE gmail =?";
                statement = connection.prepareStatement(sql);
                statement.setString(1,gmail);
                resultSet = statement.executeQuery();


                while(resultSet.next()){
                    System.out.println("name :" + resultSet.getString("name"));
                    System.out.println("age :" + resultSet.getInt("age"));
                    System.out.println("dob :" + resultSet.getDate("dob"));
                    System.out.println("gmail :" + resultSet.getString("gmail"));
                    System.out.println("address :" + resultSet.getString("address"));
                    System.out.println("mobile_no :" + resultSet.getString("mobile_no"));
                    System.out.println("nomineeName :" + resultSet.getString("nomineeName"));
                    System.out.println("balance :" + resultSet.getInt("balance"));
                    System.out.println("accountType :" + resultSet.getString("account_type"));



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
        }

    }

    @Override
    public boolean updateNameById(String name, int id) {

        System.out.println("updateNameById () invoked in DAO");
        Connection connection = null;
        PreparedStatement statement = null;


        if(id != 0){

            try{
                forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,user,password);
                String sql = "UPDATE user set name =? WHERE customer_id=?";

                statement = connection.prepareStatement(sql);
                statement.setString(1,name);
                statement.setInt(2,id);

                int row = statement.executeUpdate();
                if(row >0){
                    System.out.println("Update done .....");
                }
                else {
                    System.out.println("update canceled .......");
                }

            }catch (Exception e){
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
        return false;
    }

    @Override
    public boolean updateAgeAndDobByEmail(int age, String dob, String gmail) {

        System.out.println("updateAgeAndDobByEmail () invoked in DAO");
        Connection connection = null;
        PreparedStatement statement = null;

        if(age!= 0 && dob != null && gmail!= null){

            try{
                forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,user,password);
                String sql = "UPDATE user set age=? and dob=? where gmail=?";

                statement = connection.prepareStatement(sql);
                statement.setInt(1,age);
                statement.setString(2,dob);
                statement.setString(3,gmail);

                int row = statement.executeUpdate();
                if(row >0){
                    System.out.println("Update done .....");
                }
                else {
                    System.out.println("update canceled .......");
                }

            }catch (Exception e){
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
        return false;
    }

    @Override
    public boolean updateAddressByEmail(String address, String gmail) {

        System.out.println("updateAddressByEmail () invoked in DAO");
        Connection connection = null;
        PreparedStatement statement = null;

        if( address != null && gmail!= null){

            try{
                forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,user,password);
                String sql = "UPDATE user set address =? where gmail=?";

                statement = connection.prepareStatement(sql);

                statement.setString(1,address);
                statement.setString(2,gmail);

                int row = statement.executeUpdate();
                if(row >0){
                    System.out.println("Update done .....");
                }
                else {
                    System.out.println("update canceled .......");
                }

            }catch (Exception e){
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

        return false;
    }

    @Override
    public boolean updateMobileNoByEmail(String mobileNo, String gmail) {

        System.out.println("updateMobileNoByEmail () invoked in DAO");
        Connection connection = null;
        PreparedStatement statement = null;

        if( mobileNo != null && gmail != null){

            try{
                forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,user,password);
                String sql = "UPDATE user set mobile_no =? where gmail=?";

                statement = connection.prepareStatement(sql);

                statement.setString(1,mobileNo);
                statement.setString(2,gmail);

                int row = statement.executeUpdate();
                if(row >0){
                    System.out.println("Update done .....");
                }
                else {
                    System.out.println("update canceled .......");
                }

            }catch (Exception e){
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


        return false;
    }

    @Override
    public boolean updateNomineeNameByName(String nomineeName, String name) {
       Connection connection = null;
       PreparedStatement statement = null;

       if(nomineeName != null && name != null){
           try{
               forName("com.mysql.cj.jdbc.Driver");

               connection = DriverManager.getConnection(url,user,password);
               String sql = "UPDATE user set nomineeName =? WHERE name =?";

               statement =connection.prepareStatement(sql);
               statement.setString(1,nomineeName);
               statement.setString(2,name);

               int row = statement.executeUpdate();

               if(row>0){
                   System.out.println("update done .....");
               }
               else {
                   System.out.println("update failed ........");
               }

           }catch (Exception e){
                    e.printStackTrace();
           }finally {
               try{
                   if(statement != null){
                       statement.close();
                   }
                   if(connection != null);{
                       connection.close();
                   }
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       }


        return false;
    }

    @Override
    public boolean updateBalanceByAccountType(int balance, AccountType accountType) {

        Connection connection = null;
        PreparedStatement statement = null;

        if(balance != 0 && accountType != null){
            try{
                forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(url,user,password);
                String sql = "UPDATE user set balance =? WHERE account_type =?";

                statement =connection.prepareStatement(sql);
                statement.setInt(1,balance);
                statement.setString(2,accountType.name());

                int row = statement.executeUpdate();

                if(row>0){
                    System.out.println("update done .....");
                    return true;
                }
                else {
                    System.out.println("update failed ........");
                }

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try{
                    if(statement != null){
                        statement.close();
                    }
                    if(connection != null);{
                        connection.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public boolean deleteUserById(int id) {

        Connection connection = null;
        PreparedStatement statement = null;

        if(id != 0){

            try{
                forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,user,password);
                String sql = "DELETE FROM user WHERE customer_id =?";

                statement = connection.prepareStatement(sql);
                statement.setInt(1,id);
                int row = statement.executeUpdate();

                if(row >0){
                    System.out.println("Deleted successfully.............");
                }
                else {
                    System.out.println("Sorry delete is not initiated ");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            finally{
                try{
                    if(statement!= null){
                        statement.close();
                    }
                    if(connection!= null){
                        connection.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public List<UserDto> viewAllUsers() {
        List<UserDto> list = new ArrayList<>();
        Connection connection= null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
            String sql = "SELECT * FROM user";

            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();



            while(resultSet.next()){
                UserDto dto = new UserDto();

                dto.setName(resultSet.getString("name"));
                dto.setAge(resultSet.getString("age"));
                dto.setDob(resultSet.getString("dob"));
                dto.setGmail(resultSet.getString("gmail"));
                dto.setAddress(resultSet.getString("address"));
                dto.setMobileNo(resultSet.getString("mobile_no"));
                dto.setNomineeName(resultSet.getString("nomineeName"));
                dto.setBalance(resultSet.getInt("balance"));
                String typeFromDb = resultSet.getString("account_type");
                dto.setAccountType(AccountType.valueOf(typeFromDb));

                list.add(dto);

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(connection != null){
                    statement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void getUserNameAndAccountBalanceById(int id) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if(id != 0){
            try{

                forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,user,password);
                String sql ="SELECT name,balance FROM user WHERE customer_id =?";

                statement = connection.prepareStatement(sql);
                statement.setInt(1,id);
                resultSet = statement.executeQuery();

                while(resultSet.next()){

                    System.out.println("Name :"+resultSet.getString("name"));
                    System.out.println("balance :"+resultSet.getInt("balance"));
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
        }

    }
}
