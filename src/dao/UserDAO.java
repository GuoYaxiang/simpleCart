package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;

public class UserDAO {

	public UserDAO(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8"
				,"root","pass");
	}
	
	public User getUser(String name, String password){
		User result = null;
		String sql = "select * from user where name = ? and password = ?";
		
		try(Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
		){
			statement.setString(1, name);
			statement.setString(2, password);
			
			ResultSet rSet = statement.executeQuery();
			
			if(rSet.next()){
				result = new User();
				result.setId(rSet.getInt(1));
				result.setName(name);
				result.setPassword(password);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
