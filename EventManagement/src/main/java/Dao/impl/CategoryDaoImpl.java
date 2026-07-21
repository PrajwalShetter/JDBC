package Dao.impl;

import Dao.CategoryDao;
import Dto.CategoryDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CategoryDaoImpl implements CategoryDao {

    String url ="jdbc:mysql://localhost:3306/EventManagement_DB";
    String user = "root";
    String password = "Pajju#123";


    @Override
    public boolean addCategory(CategoryDto category) {

        if(category == null) {
            return false;
        }

        String sql = "insert into event_category(category_name,description) values(?,?)";

            try(Connection connection = DriverManager.getConnection(url,user,password);
                PreparedStatement statement = connection.prepareStatement(sql)){
                connection.setAutoCommit(false);

                statement.setString(1, category.getCategoryName());
                statement.setString(2, category.getDescription());
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
    public boolean existsById(int categoryId) {

        String sql = "SELECT * FROM event_category WHERE category_id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, categoryId);

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
