package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Studylog;


public class StudylogDao {
	public ArrayList<Studylog> getlogs(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Studylog> list = new ArrayList<Studylog>();
		try{
			conn = DBDao.getConnection();
			String sql = "select * from studylog";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Studylog item = new Studylog();
				item.setStudydate(rs.getDate("studydate"));
				item.setUsername(rs.getString("username"));
				item.setLessonnum(rs.getString("lessonnum"));
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

	public ArrayList<Studylog> getlogsbyusername(String username){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Studylog> list = new ArrayList<Studylog>();
		try{
			conn = DBDao.getConnection();
			String sql = "select * from studylog where username = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			while(rs.next()){
				Studylog item = new Studylog();
				item.setStudydate(rs.getDate("studydate"));
				item.setUsername(rs.getString("username"));
				item.setLessonnum(rs.getString("lessonnum"));
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
