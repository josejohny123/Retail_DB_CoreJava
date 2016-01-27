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

import retail.tables.objects.OrderItems_Obj;

import com.sun.corba.se.impl.io.OptionalDataException;
//Using Callable to Return Results From thread
public class Read_OrderItems_Thread_Callable implements Callable {

	HashMap<Integer, OrderItems_Obj> OrderItemsTabale = new HashMap<Integer,OrderItems_Obj>();
	InputStream fin2;
	 ObjectInputStream objin2;
	
	public HashMap<Integer, OrderItems_Obj> getOrderItemsTabale() {
		return OrderItemsTabale;
	}

	public void setOrderItemsTabale(
			HashMap<Integer, OrderItems_Obj> orderItemsTabale) {
		OrderItemsTabale = orderItemsTabale;
	}


	@Override
	public HashMap<Integer, OrderItems_Obj> call() throws Exception {


		 try {
			fin2=new FileInputStream("staging/staged_orderItems");
			objin2= new ObjectInputStream(fin2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

OrderItems_Obj storeItems;


boolean doneReadingItemsFile =false;
//Reading Objects from the file
while(!doneReadingItemsFile){

	try {
		storeItems = (OrderItems_Obj) objin2.readObject();

		OrderItemsTabale.put(storeItems.getOrder_item_order_id(), storeItems);
	} catch (EOFException eofe2) {
		doneReadingItemsFile=true;
		System.out.println("File Read complete2");
//		for(Map.Entry orderitemsmap:OrderItemsTabale.entrySet()){
//			
//			System.out.println(orderitemsmap.getValue());
//		}
	}
	catch (OptionalDataException ode2) {
		doneReadingItemsFile=ode2.eof;
		System.out.println("File Data Exception2");
		try {
			fin2.close();
			objin2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
//		for(Map.Entry orderitemsmap:OrderItemsTabale.entrySet()){
//			
//			System.out.println(orderitemsmap.getValue());
//		}

		return OrderItemsTabale;
	}
	

}
