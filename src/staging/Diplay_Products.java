package staging;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import retail.tables.objects.Products_Obj;

import com.sun.corba.se.impl.io.OptionalDataException;


public class Diplay_Products {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		InputStream fin =new FileInputStream("staging/staged_products");
		ObjectInputStream objin = new ObjectInputStream(fin);
		int i;
		List<Products_Obj> Products_Stage = new ArrayList<Products_Obj>();
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

		for (Products_Obj products_Obj : Products_Stage) {
			System.out.println(products_Obj);
		}

	}

}
