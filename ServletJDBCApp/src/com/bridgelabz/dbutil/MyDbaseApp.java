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

	public static boolean retriveValue(User user) throws SQLException, ClassNotFoundException {

		String query = "SELECT passwrd FROM Registration WHERE name=? and passwrd=?";
		Connection conn = getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(query);
		pstm.setString(1, user.getName());
		pstm.setString(2, user.getPassword());
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
//				int id = rs.getInt("id");
//				String name = rs.getString("name");
//				String passwrd = rs.getString("passwrd");
//				st.close();
			return true;
		}
		return false;
	}

}
