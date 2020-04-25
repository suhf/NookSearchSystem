package co.nook.app.common;

import java.sql.*;

public class Dao{

	public static Connection getConnection(){
		Connection conn = null;
		try{
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mariadb://coon.myds.me:3307/NookSearch";
			String userId = "minechost";
			String pw = "Ahstmxj5zos1!";
			conn = DriverManager.getConnection(url, userId, pw);

		}catch(Exception e){
			e.printStackTrace();
		}

		return conn;
	}

	public static void close(Connection conn){
		try{
			conn.close();
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
	}

}
