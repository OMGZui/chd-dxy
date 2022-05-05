package com.e.dxy.service;

import com.e.dxy.domain.UserDomain;
import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 4/4/22 5:35 PM
 */
public class DbTest {

    @Test
    public void select() {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()){
                UserDomain userDomain = new UserDomain();
                userDomain.setId(resultSet.getInt("id"));
                userDomain.setUsername(resultSet.getString("username"));
                userDomain.setPassword(resultSet.getString("password"));
                userDomain.setCreateTime(resultSet.getTime("create_time").toLocalTime());
                System.out.println(userDomain.toString());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "root");
    }

}
