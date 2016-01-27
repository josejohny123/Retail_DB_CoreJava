package file.handling;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;

	public class DeSerialize_Object { 
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	FileInputStream fin =new FileInputStream("staging/serilized_product.txt");
	ObjectInputStream objin = new ObjectInputStream(fin);
	Product p1 = (Product) objin.readObject();
	Product p2 = (Product) objin.readObject();
	System.out.println(p1);
	System.out.println(p2);
	}
	}