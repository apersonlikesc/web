package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Student;

public class UserDao {
Student Student = null;
private String SQL =""; 
//用户登录验证
public Student login(String Studentname, String password){
    SQL = "select * from login_info where Studentname = ? and password = ?";
    Connection connection = null;
    PreparedStatement pstmt = null;
    try {
        connection = DBDao.getConnection();
        pstmt = (PreparedStatement) connection.prepareStatement(SQL);
        //这里的意思将用户名和密码填到SQL语句的问号处
        pstmt.setString(1, Studentname);
        pstmt.setString(2, password);
        ResultSet rSet = (ResultSet) pstmt.executeQuery();//得到数据库的查询结果,一个数据集
        //判断结果集是否有效
        if(rSet.next()){
            Student = new Student();
            Student.setUsername(rSet.getString("Username"));
            Student.setPassword(rSet.getString("password"));
        }
        connection.close();
        pstmt.close();
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }finally{
        DBDao.closeConnection(connection);
    }
    return Student;
}
//用户注册
public boolean register(String Studentname, String password){
	SQL="insert into login_info(Studentname,password) value(?,?)";
			Connection connection = null;
			boolean flag = false;
    PreparedStatement pstmt = null;
    try {
        connection = DBDao.getConnection();
        pstmt = (PreparedStatement) connection.prepareStatement(SQL);
        //这里的意思将用户名和密码填到SQL语句的问号处
        pstmt.setString(1, Studentname);
        pstmt.setString(2, password);
        pstmt.execute();
        	flag = true;
        connection.close();
        pstmt.close();
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }finally{
        DBDao.closeConnection(connection);
    }
    return flag;
}
}
