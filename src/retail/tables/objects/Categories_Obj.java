package retail.tables.objects;

import java.io.Serializable;

public class Categories_Obj implements Serializable {

	int category_id           ;
	int category_department_id;
	String category_name       ;
	public Categories_Obj(int category_id, int category_department_id,
			String category_name) {
		super();
		this.category_id = category_id;
		this.category_department_id = category_department_id;
		this.category_name = category_name;
	}
	public int getCategory_id() {
		return category_id;
	}
	public int getCategory_department_id() {
		return category_department_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public void setCategory_department_id(int category_department_id) {
		this.category_department_id = category_department_id;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	@Override
	public String toString() {
		return "Categories_Obj [category_id=" + category_id
				+ ", category_department_id=" + category_department_id
				+ ", category_name=" + category_name + "]";
	}
	
	
	
	

}
