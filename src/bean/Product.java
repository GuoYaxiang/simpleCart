package bean;

public class Product {

	/**
	 * 产品类，包含ID、产品名称、价格三个属性。
	 */
	private int id;
	private String name;
	private float price;
	
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public float getPrice(){
		return this.price;
	}
	public void setPrice(float price){
		this.price = price;
	}

}
