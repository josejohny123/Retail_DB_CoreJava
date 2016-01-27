package file.handling;

import java.io.Serializable;

public class Product implements Serializable{
int product_Id;
String product_Name;
public Product(int prod_id, String prod_nm){
this.product_Id=prod_id;
this.product_Name=prod_nm;
}
@Override
public String toString() {
return "Product [product_Id=" + product_Id + ", product_Name=" + product_Name + "]";
}

 
}