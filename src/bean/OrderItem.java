package bean;

public class OrderItem {

	/**
	 * 订单项：包含id，对应产品，数量,订单
	 */
	private int id;
	private Product product;
	private int num;
	private Order order;
	
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public Product getProduct(){
		return this.product;
	}
	public void setProduct(Product product){
		this.product = product;
	}
	public int getNum(){
		return this.num;
	}
	public void setNum(int num){
		this.num = num;
	}
	public Order getOrder(){
		return this.order;
	}
	public void setOrder(Order order){
		this.order = order;
	}

}
