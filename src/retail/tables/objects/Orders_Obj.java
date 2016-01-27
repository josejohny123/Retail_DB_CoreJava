package retail.tables.objects;

import java.io.Serializable;
import java.sql.Timestamp;

public class Orders_Obj implements Serializable {

		int order_id ;   
		Timestamp order_date; 
		int order_customer_id;   
		String order_status;
		public Orders_Obj(int order_id, Timestamp order_date,
				int order_customer_id, String order_status) {
			super();
			this.order_id = order_id;
			this.order_date = order_date;
			this.order_customer_id = order_customer_id;
			this.order_status = order_status;
		}
		public int getOrder_id() {
			return order_id;
		}
		public void setOrder_id(int order_id) {
			this.order_id = order_id;
		}
		public Timestamp getOrder_date() {
			return order_date;
		}
		public void setOrder_date(Timestamp order_date) {
			this.order_date = order_date;
		}
		public int getOrder_customer_id() {
			return order_customer_id;
		}
		public void setOrder_customer_id(int order_customer_id) {
			this.order_customer_id = order_customer_id;
		}
		public String getOrder_status() {
			return order_status;
		}
		public void setOrder_status(String order_status) {
			this.order_status = order_status;
		}
		@Override
		public String toString() {
			return "Orders_Obj [order_id=" + order_id + ", order_date="
					+ order_date + ", order_customer_id=" + order_customer_id
					+ ", order_status=" + order_status + "]";
		}
		
	
}