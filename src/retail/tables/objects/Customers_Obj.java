package retail.tables.objects;

import java.io.Serializable;

public class Customers_Obj implements Serializable {

	int customer_id      ;
	String customer_fname ;  
	String customer_lname  ; 
	String customer_email   ;
	String customer_password;
	String customer_street  ;
	String customer_city    ;
	String customer_state   ;
	String customer_zipcode ;
	public Customers_Obj(int customer_id, String customer_fname,
			String customer_lname, String customer_email,
			String customer_password, String customer_street,
			String customer_city, String customer_state, String customer_zipcode) {
		super();
		this.customer_id = customer_id;
		this.customer_fname = customer_fname;
		this.customer_lname = customer_lname;
		this.customer_email = customer_email;
		this.customer_password = customer_password;
		this.customer_street = customer_street;
		this.customer_city = customer_city;
		this.customer_state = customer_state;
		this.customer_zipcode = customer_zipcode;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public String getCustomer_fname() {
		return customer_fname;
	}
	public String getCustomer_lname() {
		return customer_lname;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public String getCustomer_password() {
		return customer_password;
	}
	public String getCustomer_street() {
		return customer_street;
	}
	public String getCustomer_city() {
		return customer_city;
	}
	public String getCustomer_state() {
		return customer_state;
	}
	public String getCustomer_zipcode() {
		return customer_zipcode;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public void setCustomer_fname(String customer_fname) {
		this.customer_fname = customer_fname;
	}
	public void setCustomer_lname(String customer_lname) {
		this.customer_lname = customer_lname;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}
	public void setCustomer_street(String customer_street) {
		this.customer_street = customer_street;
	}
	public void setCustomer_city(String customer_city) {
		this.customer_city = customer_city;
	}
	public void setCustomer_state(String customer_state) {
		this.customer_state = customer_state;
	}
	public void setCustomer_zipcode(String customer_zipcode) {
		this.customer_zipcode = customer_zipcode;
	}
	@Override
	public String toString() {
		return "Customers_Obj [customer_id=" + customer_id
				+ ", customer_fname=" + customer_fname + ", customer_lname="
				+ customer_lname + ", customer_email=" + customer_email
				+ ", customer_password=" + customer_password
				+ ", customer_street=" + customer_street + ", customer_city="
				+ customer_city + ", customer_state=" + customer_state
				+ ", customer_zipcode=" + customer_zipcode + "]";
	}
	
	

}
