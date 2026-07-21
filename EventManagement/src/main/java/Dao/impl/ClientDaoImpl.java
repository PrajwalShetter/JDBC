package Dao.impl;

import Dao.ClientDao;
import Dto.ClientDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientDaoImpl implements ClientDao {

    String url ="jdbc:mysql://localhost:3306/EventManagement_DB";
    String user = "root";
    String password = "Pajju#123";
    @Override

    public boolean addClient(ClientDto client) {

        if(client == null){
            return false;
        }
        String sql ="insert into client(client_name,company_name,email,phone_number,address,city,state,pincode) values(?,?,?,?,?,?,?,?)";
        try(Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(sql);
        ){
            connection.setAutoCommit(false);

            statement.setString(1, client.getClientName());
            statement.setString(2, client.getCompanyName());
            statement.setString(3, client.getEmail());
            statement.setLong(4, client.getPhoneNumber());
            statement.setString(5, client.getAddress());
            statement.setString(6, client.getCity());
            statement.setString(7, client.getState());
            statement.setString(8, client.getPincode());

            int save =statement.executeUpdate();
            if(save>0){
                connection.commit();
                return true;
            }else {
                connection.rollback();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean existsById(int clientId) {

        String sql = "SELECT * FROM client WHERE client_id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, clientId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
