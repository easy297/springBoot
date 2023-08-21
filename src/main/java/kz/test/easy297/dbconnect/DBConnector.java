package kz.test.easy297.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    private Connection connection;
    public DBConnector(String url, String user, String password) {
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return this.connection;
    }
}
