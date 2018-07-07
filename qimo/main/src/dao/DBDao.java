package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDao {
	private static String USER = "root";
	private static String PASSWORD = "123";
	private static String DB_URL = "jdbc:mysql://localhost:3306/b?useUnicode=true&characterEncoding=UTF-8";
	private static String DB_DRIVER = "com.mysql.jdbc.Driver";
	
	private static Connection connection = null;
	
public static Connection getConnection(){
        try {
  
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("数据库连接异常");
            e.printStackTrace();
        }
        return connection;
    }
    public  static void closeConnection(Connection connection){

                    if(connection != null){
                        try {
                            connection.close(); // 关闭数据库连接
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
    }
