package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.DBDao;

import bean.Student;

public class StudentDao {
	

		public ArrayList<Student> getStudents() {
			ArrayList<Student> list = new ArrayList<Student>();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				conn = DBDao.getConnection();
				String sql = "select * from student";
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while(rs.next()) {
					Student item = new Student();
					item.setUsername(rs.getString("username"));
					item.setAge(rs.getInt("age"));
					item.setPassword(rs.getString("password"));
					item.setEducation(rs.getString("education"));
					item.setEmail(rs.getString("email"));
					item.setRealname(rs.getString("realname"));
					item.setTel(rs.getString("tel"));
					item.setSex(rs.getString("sex"));
					item.setStdinfo(rs.getString("stdinfo"));
					item.setTitle(rs.getString("title"));
					list.add(item);
				}
				return list;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}finally {
				if(rs != null) {
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
		public ArrayList<Student> getStudentsbyusername2(String username,String sex) {
			ArrayList<Student> list = new ArrayList<Student>();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				conn = DBDao.getConnection();
				if(username.equals("")&& !sex.equals("")) {
					String sql = "select * from student where sex=?";
					stmt = conn.prepareStatement(sql);
					stmt.setString(1,sex);
					
				}else {
					String sql = "select * from student where username=? and sex=?";
					stmt = conn.prepareStatement(sql);
					stmt.setString(1,username);
					stmt.setString(2,sex);
				}
				
				rs = stmt.executeQuery();
				while(rs.next()) {
					Student item = new Student();
					item.setUsername(rs.getString("username"));
					item.setAge(rs.getInt("age"));
					item.setPassword(rs.getString("password"));
					item.setEducation(rs.getString("education"));
					item.setEmail(rs.getString("email"));
					item.setRealname(rs.getString("realname"));
					item.setTel(rs.getString("tel"));
					item.setSex(rs.getString("sex"));
					item.setStdinfo(rs.getString("stdinfo"));
					item.setTitle(rs.getString("title"));
					list.add(item);
				}
				return list;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}finally {
				if(rs != null) {
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
		public boolean rmStudent(String username) {
			Connection conn = null;
			PreparedStatement stmt = null;
			try {
				conn = DBDao.getConnection();
				String sql = "DELETE FROM student WHERE username=?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, username);
				stmt.execute();	
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}finally {
				
				
				if(stmt != null) {
					try {
						stmt.close();
						stmt=null;
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			return true;
		}
		public boolean addStudent(Student std) {
			Connection conn = null;
			PreparedStatement stmt = null;
			
			try {		
				conn = DBDao.getConnection();
				String sql = "INSERT INTO student(username,password,age,sex,tel,email,title,education,realname,head,stdinfo) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, std.getUsername());
				stmt.setString(2, std.getPassword());
				stmt.setInt(3, std.getAge());
				stmt.setString(4, std.getSex());
				stmt.setString(5, std.getTel());
				stmt.setString(6, std.getEmail());
				stmt.setString(7, std.getTitle());
				stmt.setString(8, std.getEducation());
				stmt.setString(9, std.getRealname());
				stmt.setString(10, std.getHead());
				stmt.setString(11, std.getStdinfo());
				stmt.execute();
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}finally {
				
				if(stmt != null) {
					try {
						stmt.close();
						stmt=null;
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			return true;
		}
		public boolean changeStudent(Student std) {
			Connection conn = null;
			PreparedStatement stmt = null;
			
			try {		
				conn = DBDao.getConnection();
				String sql = "UPDATE student SET password=?,age=?,sex=?,tel=?,email=?,title=?,education=?,realname=?,head=?,stdinfo=?  WHERE username=?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, std.getPassword());
				stmt.setInt(2, std.getAge());
				stmt.setString(3, std.getSex());
				stmt.setString(4, std.getTel());
				stmt.setString(5, std.getEmail());
				stmt.setString(6, std.getTitle());
				stmt.setString(7, std.getEducation());
				stmt.setString(8, std.getRealname());
				stmt.setString(9, std.getHead());
				stmt.setString(10, std.getStdinfo());
				stmt.setString(11, std.getUsername());
				stmt.execute();
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}finally {
				
				if(stmt != null) {
					try {
						stmt.close();
						stmt=null;
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			return true;
		}
		public Student getstudentbyusername(String username){
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try{
				conn = DBDao.getConnection();
				String sql = "select * from student where username= ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, username);
				rs = stmt.executeQuery();
				Student item = new Student();
				rs.next();
				item.setUsername(rs.getString("username"));
				item.setAge(rs.getInt("age"));
				item.setPassword(rs.getString("password"));
				item.setEducation(rs.getString("education"));
				item.setEmail(rs.getString("email"));
				item.setRealname(rs.getString("realname"));
				item.setTel(rs.getString("tel"));
				item.setHead(rs.getString("head"));
				item.setSex(rs.getString("sex"));
				item.setStdinfo(rs.getString("stdinfo"));
				item.setTitle(rs.getString("title"));
				return item;
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
