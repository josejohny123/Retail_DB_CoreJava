package retail.tables.objects;

import java.io.Serializable;

public class Products_Obj implements Serializable {
	int product_id;   
	int product_category_id;     
	String product_name;
	String product_description;
	float product_price ;  
	String product_image;
	public Products_Obj(int product_id, int product_category_id,
			String product_name, String product_description,
			float product_price, String product_image) {
		super();
		this.product_id = product_id;
		this.product_category_id = product_category_id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.product_price = product_price;
		this.product_image = product_image;
	}
	
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getProduct_category_id() {
		return product_category_id;
	}

	public void setProduct_category_id(int product_category_id) {
		this.product_category_id = product_category_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public float getProduct_price() {
		return product_price;
	}

	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	@Override
	public String toString() {
		return "Products_Obj [product_id=" + product_id
				+ ", product_category_id=" + product_category_id
				+ ", product_name=" + product_name + ", product_description="
				+ product_description + ", product_price=" + product_price
				+ ", product_image=" + product_image + "]";
	}
	

}
