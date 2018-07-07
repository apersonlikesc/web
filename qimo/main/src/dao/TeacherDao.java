package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Teacher;


public class TeacherDao {
	public ArrayList<Teacher> getteachers(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		try{
			conn = DBDao.getConnection();
			String sql = "select * from teacher";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Teacher item = new Teacher();
				item.setAge(rs.getInt("age"));
				item.setSex(rs.getString("sex"));
				item.setNumber(rs.getString("number"));
				item.setTel(rs.getString("tel"));
				item.setEmail(rs.getString("email"));
				item.setName(rs.getString("name"));
				list.add(item);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if(rs!=null) {
				try {
					rs.close();
					rs=null;
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
					stmt=null;
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		}

	public ArrayList<Teacher> getteachersbyname(String name,String sex){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		try{
			conn = DBDao.getConnection();
			if(name.equals("")&& !sex.equals("")) {
				String sql = "select * from teacher where sex=?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1,sex);
				
			}else {
				String sql = "select * from teacher where name=? and sex=?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1,name);
				stmt.setString(2,sex);
			}
			
			rs = stmt.executeQuery();
			while(rs.next()){
				Teacher item = new Teacher();
				item.setAge(rs.getInt("age"));
				item.setSex(rs.getString("sex"));
				item.setNumber(rs.getString("number"));
				item.setTel(rs.getString("tel"));
				item.setEmail(rs.getString("email"));
				item.setName(rs.getString("name"));
				list.add(item);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if(rs!=null) {
				try {
					rs.close();
					rs=null;
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
					stmt=null;
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		}

	
}