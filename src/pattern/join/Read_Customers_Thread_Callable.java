package pattern.join;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.concurrent.Callable;

import retail.tables.objects.Customers_Obj;

import com.sun.corba.se.impl.io.OptionalDataException;

public class Read_Customers_Thread_Callable implements Callable {

	HashMap<Integer, Customers_Obj> CustomerTabale = new HashMap<Integer,Customers_Obj>();
	InputStream fin;
	ObjectInputStream objin;
	

	
	@Override
	public HashMap<Integer, Customers_Obj> call() throws Exception {
		

    	
		
		try {
			fin = new FileInputStream("staging/staged_customers");
			
			objin = new ObjectInputStream(fin);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Customers_Obj store;


		boolean doneReadingFile =false;
		//Reading Objects from the file
		while(!doneReadingFile){

			try {
				store = (Customers_Obj) objin.readObject();

				CustomerTabale.put(store.getCustomer_id(), store);
			} catch (EOFException eofe) {
				doneReadingFile=true;
				System.out.println("File Read complete1");
//				for(Map.Entry orderitemsmap:CustomerTabale.entrySet()){
//					
//					System.out.println(orderitemsmap.getValue());
//				}
				try {
					fin.close();
					objin.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			catch (OptionalDataException ode) {
				doneReadingFile=ode.eof;
				System.out.println("File Data Exception");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//		for(Map.Entry orderitemsmap:CustomerTabale.entrySet()){
		//			
		//			System.out.println(orderitemsmap.getValue());
		//		}

		
	
		return CustomerTabale;
}
}
