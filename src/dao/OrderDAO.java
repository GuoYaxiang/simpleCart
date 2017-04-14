package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Order;

public class OrderDAO {

	public OrderDAO(){
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
	
	public void insert(Order o){
		String sql = "insert into order_ values(null,?)";
		
		try(Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
		){
			statement.setInt(1, o.getUser().getId()); //设置uid
			statement.execute();
			
			ResultSet rSet = statement.getGeneratedKeys();
			if(rSet.next()){
				int id = rSet.getInt(1);
				o.setId(id);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
