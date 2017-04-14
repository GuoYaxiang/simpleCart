package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.OrderItem;

public class OrderItemDAO {

	public OrderItemDAO(){
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
	
	public void insert(OrderItem oi){
		String sql = "insert into orderitem values(null,?,?,?)";
		
		try(Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
		){
			statement.setInt(1, oi.getProduct().getId());
			statement.setInt(2, oi.getNum());
			statement.setInt(3, oi.getOrder().getId());
			
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
