package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Info;

public class GonggaoDao {
	public ArrayList<Info> getGonggaos(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Info> list = new ArrayList<Info>();
		try{
			conn = DBDao.getConnection();
			String sql = "select * from info";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Info item = new Info();
				item.setCreatedate(rs.getDate("createdate"));
				item.setInfo(rs.getString("info"));
				item.setInfo_class(rs.getString("class"));
				item.setTitle(rs.getString("title"));
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

	public ArrayList<Info> getGonggaosbyclass(String a){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Info> list = new ArrayList<Info>();
		try{
			conn = DBDao.getConnection();
			String sql = "select * from info where class=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, a);
			rs = stmt.executeQuery();
			while(rs.next()){
				Info item = new Info();
				item.setCreatedate(rs.getDate("createdate"));
				item.setInfo(rs.getString("info"));
				item.setInfo_class(rs.getString("class"));
				item.setTitle(rs.getString("title"));
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

			
		public boolean rmGonggao(String title,Date date) {
			Connection conn = null;
			PreparedStatement stmt = null;
			try {
				conn = DBDao.getConnection();
				String sql = "DELETE FROM info WHERE title=?and createdate=?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, title);
				stmt.setDate(2, date);
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
		
		public boolean addGonggao(Info gg) {
			Connection conn = null;
			PreparedStatement stmt = null;
			
			try {		
				conn = DBDao.getConnection();
				String sql = "INSERT INTO info(title,createdate,class,info) VALUES (?,?,?,?)";
			
				stmt = conn.prepareStatement(sql);
			
				stmt.setString(1, gg.getTitle());
				stmt.setDate(2, gg.getCreatedate());
				stmt.setString(3, gg.getInfo_class());
				stmt.setString(4, gg.getInfo());
				
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

