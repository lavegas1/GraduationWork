package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.json.simple.parser.ParseException;

import util.ConnectionPool;

public class FriendDAO {

	public String insert(String uid, String frid) throws NamingException,SQLException,ParseException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT id FROM friend WHERE id = ? AND frid = ?";
			
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uid);
			stmt.setString(2, frid);
			
			rs = stmt.executeQuery();
			if(rs.next()) return "EX";
			
			stmt.close();
			
			sql = "INSERT INTO friend VALUES(?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uid);
			stmt.setString(2, frid);
			
			int count = stmt.executeUpdate();
			return (count == 1) ? "OK" : "ER";
		}finally {
			if(rs != null) rs.close();
			if(conn != null) conn.close();
			if(stmt != null) stmt.close();
		}
	}
	
	public String remove(String uid, String frid) throws NamingException,SQLException,ParseException{
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			String sql = "DELETE FROM friend WHERE id = ? AND frid = ?";
			
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uid);
			stmt.setString(2, frid);
			
			int count = stmt.executeUpdate();
			return (count == 1) ? "OK" : "ER";
		}finally {
			if(conn != null) conn.close();
			if(stmt != null) stmt.close();
		}
	}
	
	public String getList(String uid)throws NamingException,SQLException,ParseException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT frid FROM friend WHERE id = ?";
			
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uid);
			rs = stmt.executeQuery();
			
			String str =""; int cnt = 0;
			while(rs.next()) {
				if(cnt++ > 0) str += ",";
				str += "\"" + rs.getString("frid") + "\"";
			}
			if(cnt ==0) return "[]";
			
			rs.close(); stmt.close();
			sql = "SELECT jsonstr FROM user WHERE id IN ("+ str +")";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			str = "["; cnt = 0;
			while(rs.next()) {
				if(cnt++>0) str += ", ";
				str += rs.getString("jsonstr");
			}
			str += "]";
			
			return str;
		}finally {
			if(rs != null) rs.close();
			if(conn != null) conn.close();
			if(stmt != null) stmt.close();
		}
	}
}
