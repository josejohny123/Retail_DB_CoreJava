package pattern.summarization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import retail.tables.objects.Products_Obj;

import com.sun.corba.se.impl.io.OptionalDataException;

public class MaxPricedProduct {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		InputStream fin =new FileInputStream("staging/staged_products");
		ObjectInputStream objin = new ObjectInputStream(fin);
		int i;
		ArrayList<Products_Obj> Products_Stage = new ArrayList<Products_Obj>();
		boolean doneReadingFile =false;
		//Reading Objects from the file
		while(!doneReadingFile){

			try {
				Products_Stage.add((Products_Obj) objin.readObject());
			} catch (EOFException eofe) {
				doneReadingFile=true;
				System.out.println("File Read complete");
			}
			catch (OptionalDataException ode) {
				doneReadingFile=ode.eof;
				System.out.println("File Data Exception");
			}

		}
		//Max Price Logic
		Products_Obj MaxPricedProduct = new Products_Obj(0, 0, null, null, 0, null);
		for (Products_Obj products_Obj : Products_Stage) {
			if(products_Obj.getProduct_price()>MaxPricedProduct.getProduct_price() ){
				MaxPricedProduct=products_Obj;
			}

		}
		
		System.out.println(MaxPricedProduct);

	}
}