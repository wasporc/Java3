package ru.geekbrains.java3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class UserDAO implements Service<User>{
    public boolean checkPass(String name, String pass){
        try(Connection connection = DBService.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where name = ? and password = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, pass);
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User changeUserName(String oldName, String newName){
        User user = null;
        try(Connection connection = DBService.getConnection()){
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update users set name = ? where name = ?");
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, oldName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public Collection<User> findAll() {
        return null;
    }

    @Override
    public int save(User o) {
        return 0;
    }
}
