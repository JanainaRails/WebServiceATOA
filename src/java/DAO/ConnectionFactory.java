package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    public Connection getConnection() throws SQLException{ 
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/atoa";
            String user = "root";
            String senha = "";
            return  DriverManager.getConnection(url, user, senha);
        }catch(SQLException e){
            throw new RuntimeException("Erro de conexão");
        }catch (Exception ex) {
            throw new RuntimeException("Erro");
        }
    }
}
