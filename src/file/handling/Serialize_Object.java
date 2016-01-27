package file.handling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialize_Object {

public static void main(String[] args) throws IOException {

Product p1 = new Product(11,"Computer");
Product p2 = new Product(12,"LapTop");
 
FileOutputStream fo = new FileOutputStream("staging/serilized_product.txt");
ObjectOutputStream oobj = new ObjectOutputStream(fo);
oobj.writeObject(p1);
oobj.writeObject(p2);
oobj.flush();
System.out.println("Success");
}
}