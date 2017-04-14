package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Product;


public class ProductDAO {

	public static void main(String[] args) {
		System.out.println(new ProductDAO().ListProduct().size());
	}
	
	public ProductDAO(){
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
	
	public int getTotal(){
		int total = 0;
		try(Connection connection = getConnection();
			Statement statement = connection.createStatement();	
		){
			String sql = "select count(*) from product";
			
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	
	//根据商品id获取商品对象
	public Product getProduct(int id){
		Product result = null;
		String sql = "select * from product where id = ?";
		
		try(Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
		){
			statement.setInt(1, id);
			ResultSet rSet = statement.executeQuery();
			
			if(rSet.next()){
				result = new Product();
				result.setId(id);
				result.setName(rSet.getString("name"));
				result.setPrice(rSet.getFloat("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	//返回商品列表
	public List<Product> ListProduct(){
		return this.ListProduct(0, Short.MAX_VALUE);
	}
	
	public List<Product> ListProduct(int start, int count){
		List<Product> products = new ArrayList<Product>();
		String sql = "select * from product order by id desc limit ?,?";
		
		try(Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
		){
			statement.setInt(1, start);
			statement.setInt(2, count);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				Product product = new Product();
				product.setId(resultSet.getInt(1));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getFloat("price"));
				
				products.add(product);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

}
