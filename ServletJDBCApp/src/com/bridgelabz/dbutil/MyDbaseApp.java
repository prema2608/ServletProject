package com.bridgelabz.dbutil;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bridgelabz.model.User;

import java.sql.Connection;

public class MyDbaseApp {
	
	
	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {

		String hostName = "localhost";
		String dbName = "ServletProject";
		String userName = "root";
		String password = "root";
		return getMySQLConnection(hostName, dbName, userName, password);
	}

	public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password)
			throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");

		// URL Connection for MySQL:
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}
	

	public static void registration(User user) throws SQLException, ClassNotFoundException {
		String sql = "Insert into Registration(id ,name, email,pnumb,passwrd) values (?,?,?,?,?)";
		Connection conn = getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, user.getId());
		System.out.println(user.toString());
		pstm.setString(2, user.getName());
		pstm.setString(3, user.getEmail());
		pstm.setLong(4, user.getPnumb());
		pstm.setString(5, user.getPassword());
		pstm.execute();
		conn.close();
	}

	public static User retriveValue(User user) throws SQLException, ClassNotFoundException {

		String query = "SELECT * FROM Registration WHERE name=? and passwrd=?";
		Connection conn = getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(query);
		pstm.setString(1, user.getName());
		pstm.setString(2, user.getPassword());
		ResultSet rs = pstm.executeQuery();
		User user2=null;
		while (rs.next()) {
//				int id = rs.getInt("id");
//				String name = rs.getString("name");
//				String passwrd = rs.getString("passwrd");
//				st.close();
			user2 =new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5));
			
		}
		
		return user2;
	}
	
	public static void edit(User user) throws ClassNotFoundException, SQLException
	{
		String query = "UPDATE  Registration SET email=?, pnumb=?,passwrd=? WHERE name=?";

		Connection conn=getMySQLConnection();
		 PreparedStatement stmt = conn.prepareStatement(query);
		 stmt.setString(4, user.getName());
		 stmt.setString(1, user.getEmail());
		 stmt.setLong(2, user.getPnumb());
		 stmt.setString(3, user.getPassword());
	
		 
		 int i=stmt.executeUpdate();
		 System.out.println(i);
}

}
