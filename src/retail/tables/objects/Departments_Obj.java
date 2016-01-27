package retail.tables.objects;

import java.io.Serializable;

public class Departments_Obj implements Serializable {
	
	public Departments_Obj(int department_id, String department_name) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
	}
	int department_id;  
	String department_name;
	public int getDepartment_id() {
		return department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	@Override
	public String toString() {
		return "Departments_Obj [department_id=" + department_id
				+ ", department_name=" + department_name + "]";
	}
	
	


}
