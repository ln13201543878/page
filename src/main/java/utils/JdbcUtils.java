package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
	   static String  driver="com.mysql.jdbc.Driver";
	   static String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf8";
	   static String user="root";
	   static String password="";
	   static Connection conn;
	   static {
		   try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	   }
	   
	   public static Connection getcon() throws SQLException {
		   conn=DriverManager.getConnection(url,user,password);
		  return conn;
	   }
	   public static void close(ResultSet rs,Statement sta,Connection conn) {
			try {
				if(rs != null) rs.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					if(sta != null) sta.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				} finally {
					try {
						if(conn != null) conn.close();
					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				}
			}
	   }
	   
}
