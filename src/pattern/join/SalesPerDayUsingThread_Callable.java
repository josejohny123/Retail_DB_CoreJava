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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

	import retail.tables.objects.OrderItems_Obj;
import retail.tables.objects.Orders_Obj;

import com.sun.corba.se.impl.io.OptionalDataException;

/*Using Callable to Return Results From Runnables
https://blogs.oracle.com/CoreJavaTechTips/entry/get_netbeans_6
Callable interface introduced in J2SE 5.0. Instead of having a run() method, the Callable interface offers a call() method, 
which can return an Object or, more specifically, any type that is introduced in the genericized form:

Because you cannot pass a Callable into a Thread to execute, you instead use the ExecutorService to execute the Callable object. 
The service accepts Callable objects to run by way of the submit() method:

<T> Future<T> submit(Callable<T> task)
As the method definition shows, submitting a Callable object to the ExecutorService returns a Future object. The get() method of Future will then block until the task is completed. 
*/

	public class SalesPerDayUsingThread_Callable {

		public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException, ExecutionException {
			

			HashMap<Integer, Orders_Obj> OrderTabale = new HashMap<Integer,Orders_Obj>();
			HashMap<Integer, OrderItems_Obj> OrderItemsTabale = new HashMap<Integer,OrderItems_Obj>();
			
			//Using 
			  ExecutorService pool = Executors.newFixedThreadPool(2);
			  Read_Order_Thread_Callable callableOrder = new Read_Order_Thread_Callable();
			  Read_OrderItems_Thread_Callable callableOrderItems = new Read_OrderItems_Thread_Callable();
			  
			  
		       Future<HashMap<Integer, Orders_Obj>>  return_OrderItems_Thread;
		       Future<HashMap<Integer, OrderItems_Obj>>  returnfromOrderItems;
		       return_OrderItems_Thread = pool.submit(callableOrder);
		       returnfromOrderItems = pool.submit(callableOrderItems);
		        
		       OrderTabale = return_OrderItems_Thread.get();
		       OrderItemsTabale = returnfromOrderItems.get();
			
		
		/*	for(Map.Entry orderitemsmap:OrderTabale.entrySet()){
							
							System.out.println(orderitemsmap.getValue());
						}
			
			
        		for(Map.Entry orderitemsmap:OrderItemsTabale.entrySet()){
        					
        					System.out.println(orderitemsmap.getValue());
        				}
			*/
			
		    
				 

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

		
