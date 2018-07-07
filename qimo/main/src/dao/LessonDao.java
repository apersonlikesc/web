package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Lesson;


public class LessonDao {
	public ArrayList<Lesson> getlessons(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Lesson> list = new ArrayList<Lesson>();
		try{
			conn = DBDao.getConnection();
			String sql = "select * from lesson";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Lesson item = new Lesson();
				item.setLessonnum(rs.getInt("lessonnum"));
				item.setLessonclass(rs.getString("lessonclass"));
				item.setLessonname(rs.getString("lessonname"));
				item.setLessinfo(rs.getString("lessinfo"));
				item.setLessbg(rs.getDate("lessbg"));
				item.setLessend(rs.getDate("lessend"));
				item.setTeacher(rs.getString("teacher"));
				item.setAmount(rs.getInt("amount"));
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
	
	public ArrayList<Lesson> getlessonsbyname(String lessonname,String type){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Lesson> list = new ArrayList<Lesson>();
		try{
			conn = DBDao.getConnection();
			System.out.println(lessonname);
			System.out.println(type);
			if(lessonname.equals("") && !type.equals("")) {
				String sql = "select * from lesson where lessonclass=?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1,type);
			}else {
				String sql = "select * from lesson where lessonname=? and lessonclass=?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1,lessonname);
				stmt.setString(2,type);
			}
			
			rs = stmt.executeQuery();
			while(rs.next()){
				Lesson item = new Lesson();
				item.setLessonnum(rs.getInt("lessonnum"));
				item.setLessonclass(rs.getString("lessonclass"));
				item.setLessonname(rs.getString("lessonname"));
				item.setLessinfo(rs.getString("lessinfo"));
				item.setLessbg(rs.getDate("lessbg"));
				item.setLessend(rs.getDate("lessend"));
				item.setTeacher(rs.getString("teacher"));
				item.setAmount(rs.getInt("amount"));
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
	public Lesson getlessonsbynum(int index){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBDao.getConnection();
			System.out.println(index);
			String sql = "select * from lesson where lessonnum= ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, index);
			rs = stmt.executeQuery();
			Lesson item = new Lesson();
			rs.next();
			item.setLessonnum(rs.getInt("lessonnum"));
			item.setLessonclass(rs.getString("lessonclass"));
			item.setLessonname(rs.getString("lessonname"));
			item.setLessinfo(rs.getString("lessinfo"));
			item.setLessbg(rs.getDate("lessbg"));
			item.setPic(rs.getString("pic"));
			item.setLessend(rs.getDate("lessend"));
			item.setTeacher(rs.getString("teacher"));
			item.setAmount(rs.getInt("amount"));
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
		public boolean rmlesson(int lessonnum) {
			Connection conn = null;
			PreparedStatement stmt = null;
			try {
				conn = DBDao.getConnection();
				String sql = "DELETE FROM lesson WHERE lessonnum=?";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, lessonnum);
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
		public boolean addLesson(Lesson lesson) {
			Connection conn = null;
			PreparedStatement stmt = null;
			
			try {		
				conn = DBDao.getConnection();
				String sql = "INSERT INTO lesson(lessonclass,lessonname,lessinfo,lessbg,lessend,teacher,pic) VALUES (?,?,?,?,?,?,?)";
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, lesson.getLessonclass());
				stmt.setString(2, lesson.getLessonname());
				stmt.setString(3, lesson.getLessinfo());
				stmt.setDate(4, lesson.getLessbg());
				stmt.setDate(5, lesson.getLessend());
				stmt.setString(6, lesson.getTeacher());
				stmt.setString(7, lesson.getPic());
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
		public boolean changeLesson(Lesson lesson) {
			Connection conn = null;
			PreparedStatement stmt = null;
			
			try {		
				conn = DBDao.getConnection();
				String sql = "update lesson set lessonclass = ?,lessonname = ?,lessinfo = ?,lessbg=?,lessend=?,teacher=?,pic=? where lessonnum=?";
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, lesson.getLessonclass());
				stmt.setString(2, lesson.getLessonname());
				stmt.setString(3, lesson.getLessinfo());
				stmt.setDate(4, lesson.getLessbg());
				stmt.setDate(5, lesson.getLessend());
				stmt.setString(6, lesson.getTeacher());
				stmt.setString(7, lesson.getPic());
				stmt.setInt(8, lesson.getLessonnum());
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
}

