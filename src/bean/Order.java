package bean;

public class Order {

	/**
	 * 订单：包含id、用户
	 */
	private int id;
	private User user;
	
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public User getUser(){
		return this.user;
	}
	public void setUser(User user){
		this.user = user;
	}

}
