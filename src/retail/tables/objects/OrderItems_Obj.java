package retail.tables.objects;

import java.io.Serializable;

public class OrderItems_Obj implements Serializable {
	int order_item_id ;          
	int order_item_order_id   ;  
	int  order_item_product_id  ; 
	int order_item_quantity     ;
	float order_item_subtotal     ;
	float order_item_product_price;
	public OrderItems_Obj(int order_item_id, int order_item_order_id,
			int order_item_product_id, int order_item_quantity,
			float order_item_subtotal, float order_item_product_price) {
		super();
		this.order_item_id = order_item_id;
		this.order_item_order_id = order_item_order_id;
		this.order_item_product_id = order_item_product_id;
		this.order_item_quantity = order_item_quantity;
		this.order_item_subtotal = order_item_subtotal;
		this.order_item_product_price = order_item_product_price;
	}
	public int getOrder_item_id() {
		return order_item_id;
	}
	public void setOrder_item_id(int order_item_id) {
		this.order_item_id = order_item_id;
	}
	public int getOrder_item_order_id() {
		return order_item_order_id;
	}
	public void setOrder_item_order_id(int order_item_order_id) {
		this.order_item_order_id = order_item_order_id;
	}
	public int getOrder_item_product_id() {
		return order_item_product_id;
	}
	public void setOrder_item_product_id(int order_item_product_id) {
		this.order_item_product_id = order_item_product_id;
	}
	public int getOrder_item_quantity() {
		return order_item_quantity;
	}
	public void setOrder_item_quantity(int order_item_quantity) {
		this.order_item_quantity = order_item_quantity;
	}
	public float getOrder_item_subtotal() {
		return order_item_subtotal;
	}
	public void setOrder_item_subtotal(float order_item_subtotal) {
		this.order_item_subtotal = order_item_subtotal;
	}
	public float getOrder_item_product_price() {
		return order_item_product_price;
	}
	public void setOrder_item_product_price(float order_item_product_price) {
		this.order_item_product_price = order_item_product_price;
	}
	@Override
	public String toString() {
		return "OrderItems_Obj [order_item_id=" + order_item_id
				+ ", order_item_order_id=" + order_item_order_id
				+ ", order_item_product_id=" + order_item_product_id
				+ ", order_item_quantity=" + order_item_quantity
				+ ", order_item_subtotal=" + order_item_subtotal
				+ ", order_item_product_price=" + order_item_product_price
				+ "]";
	}

	
	

}
