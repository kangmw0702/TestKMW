package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;

public class JejuConnectionMaker implements ConnectionMaker {

    @Value("${db.id}")
    private String id;
    @Value("${db.url}")
    private String url;
    @Value("${db.title}")
    private String title;
    @Value("${db.price}")
    private String price;

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(id);
        return DriverManager.getConnection(url
                , id, price);
    }
}