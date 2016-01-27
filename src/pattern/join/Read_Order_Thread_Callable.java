package pattern.join;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import retail.tables.objects.Orders_Obj;

import com.sun.corba.se.impl.io.OptionalDataException;

//Using Callable to Return Results From thread
public class Read_Order_Thread_Callable implements Callable {

	HashMap<Integer, Orders_Obj> OrderTabale = new HashMap<Integer,Orders_Obj>();
	InputStream fin;
	ObjectInputStream objin;
	

	
	@Override
	public HashMap<Integer, Orders_Obj> call() throws Exception {
		

    	
		
		try {
			fin = new FileInputStream("staging/staged_orders");
			
			objin = new ObjectInputStream(fin);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Orders_Obj store;


		boolean doneReadingFile =false;
		//Reading Objects from the file
		while(!doneReadingFile){

			try {
				store = (Orders_Obj) objin.readObject();

				OrderTabale.put(store.getOrder_id(), store);
			} catch (EOFException eofe) {
				doneReadingFile=true;
				System.out.println("File Read complete1");
//				for(Map.Entry orderitemsmap:OrderTabale.entrySet()){
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
		//		for(Map.Entry orderitemsmap:OrderTabale.entrySet()){
		//			
		//			System.out.println(orderitemsmap.getValue());
		//		}

		
	
		return OrderTabale;
	}
}
