package pattern.join;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import retail.tables.objects.OrderItems_Obj;
import retail.tables.objects.Orders_Obj;

import com.sun.corba.se.impl.io.OptionalDataException;

public class SalesPerDay {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//Read Orders from order table
		InputStream fin =new FileInputStream("staging/staged_orders");
		ObjectInputStream objin = new ObjectInputStream(fin);
		Orders_Obj store;
		HashMap<Integer, Orders_Obj> OrderTabale = new HashMap<Integer,Orders_Obj>();


		boolean doneReadingFile =false;
		//Reading Objects from the file
		while(!doneReadingFile){

			try {
				store = (Orders_Obj) objin.readObject();

				OrderTabale.put(store.getOrder_id(), store);
			} catch (EOFException eofe) {
				doneReadingFile=true;
				System.out.println("File Read complete1");
			}
			catch (OptionalDataException ode) {
				doneReadingFile=ode.eof;
				System.out.println("File Data Exception");
			}

		}
		//		for(Map.Entry orderitemsmap:OrderTabale.entrySet()){
		//			
		//			System.out.println(orderitemsmap.getValue());
		//		}

		//fin.close();
		//objin.close();
		//Read Order Items from order_items table
		fin =new FileInputStream("staging/staged_orderItems");
		objin = new ObjectInputStream(fin);

		OrderItems_Obj storeItems;
		HashMap<Integer, OrderItems_Obj> OrderItemsTabale = new HashMap<Integer,OrderItems_Obj>();


		boolean doneReadingItemsFile =false;
		//Reading Objects from the file
		while(!doneReadingItemsFile){

			try {
				storeItems = (OrderItems_Obj) objin.readObject();

				OrderItemsTabale.put(storeItems.getOrder_item_order_id(), storeItems);
			} catch (EOFException eofe2) {
				doneReadingItemsFile=true;
				System.out.println("File Read complete2");
			}
			catch (OptionalDataException ode2) {
				doneReadingItemsFile=ode2.eof;
				System.out.println("File Data Exception2");
			}

		}
		//		for(Map.Entry orderitemsmap:OrderItemsTabale.entrySet()){
		//			
		//			System.out.println(orderitemsmap.getValue());
		//		}
		fin.close();
		objin.close();



		//Join two hash Maps Orders and Order Items based on Order ID
		//OrderItemsTabale  and OrderTabale Hashmaps are joined here
		//Created Join Tree map for Total sales per day
		TreeMap<Timestamp, Float> TotalSalesPerDay	= new TreeMap<Timestamp, Float>();
		OrderItems_Obj storeItems1=null;
		Orders_Obj storeorders1 = null;
		for(Map.Entry orderitemsmap:OrderItemsTabale.entrySet()){
			storeItems1 = (OrderItems_Obj) orderitemsmap.getValue();
			storeorders1 = OrderTabale.get(storeItems1.getOrder_item_order_id());
			Float price=(float) 0;
			if (storeorders1!=null) {
				if(TotalSalesPerDay.containsKey(storeorders1.getOrder_date()))
					price = TotalSalesPerDay.get(storeorders1.getOrder_date());
				TotalSalesPerDay.put(storeorders1.getOrder_date(), price+storeItems1.getOrder_item_subtotal());
			}
			else
			{
				TotalSalesPerDay.put(storeorders1.getOrder_date(), storeItems1.getOrder_item_subtotal());

			}



		}
		for(Map.Entry m:TotalSalesPerDay.entrySet()){  
			System.out.println("Day " +m.getKey()+" Sale "+m.getValue());  
		}  



	}
}


