package pattern.filtering;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import Date.Month;
import pattern.join.Read_OrderItems_Thread_Callable;
import pattern.join.Read_Order_Thread_Callable;
import pattern.join.Read_Products_Thread_Callable;
import retail.tables.objects.OrderItems_Obj;
import retail.tables.objects.Orders_Obj;
import retail.tables.objects.Products_Obj;

public class TopTenProductsSoldPerMonth {

	/*Using Callable to Return Results From Runnables
	https://blogs.oracle.com/CoreJavaTechTips/entry/get_netbeans_6
	Callable interface introduced in J2SE 5.0. Instead of having a run() method, the Callable interface offers a call() method, 
	which can return an Object or, more specifically, any type that is introduced in the genericized form:

	Because you cannot pass a Callable into a Thread to execute, you instead use the ExecutorService to execute the Callable object. 
	The service accepts Callable objects to run by way of the submit() method:

	<T> Future<T> submit(Callable<T> task)
	As the method definition shows, submitting a Callable object to the ExecutorService returns a Future object. The get() method of Future will then block until the task is completed. 
	 */

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException, ExecutionException {


		HashMap<Integer, Orders_Obj> OrderTabale = new HashMap<Integer,Orders_Obj>();
		HashMap<Integer, OrderItems_Obj> OrderItemsTabale = new HashMap<Integer,OrderItems_Obj>();
		HashMap<Integer, Products_Obj> ProductsTable = new HashMap<Integer, Products_Obj>();
		//
		ExecutorService pool = Executors.newFixedThreadPool(3);
		Read_Order_Thread_Callable callableOrder = new Read_Order_Thread_Callable();
		Read_OrderItems_Thread_Callable callableOrderItems = new Read_OrderItems_Thread_Callable();
		Read_Products_Thread_Callable callableProducts = new Read_Products_Thread_Callable();

		Future<HashMap<Integer, Orders_Obj>>  return_OrderItems_Thread;
		Future<HashMap<Integer, OrderItems_Obj>>  returnfromOrderItems;
		Future<HashMap<Integer, Products_Obj>> returnProducts;

		return_OrderItems_Thread = pool.submit(callableOrder);
		returnfromOrderItems = pool.submit(callableOrderItems);
		returnProducts = pool.submit(callableProducts);

		OrderTabale = return_OrderItems_Thread.get();
		OrderItemsTabale = returnfromOrderItems.get();
		ProductsTable = returnProducts.get();

		pool.shutdown();
		pool.awaitTermination(5,TimeUnit.MINUTES);
		//Join two hash Maps Orders and Order Items based on Order ID
		//OrderItemsTabale  and OrderTabale Hashmaps are joined here
		//Created Join Tree map for Monthly Count of Products 

		//Creating Custom Object with Year,Month and Product ID. Then finding the Count of sales/product
		HashMap<MonthProductId, Integer> TotalSalesPerMonthPerProduct	= new HashMap<MonthProductId, Integer>();

		OrderItems_Obj storeItems1=null;
		Orders_Obj storeorders1 = null;
		MonthProductId monthProductId = new MonthProductId(-1, -1, 999999);
		int count = 0;
		for(Map.Entry orderitemsmap:OrderItemsTabale.entrySet()){
			storeItems1 = (OrderItems_Obj) orderitemsmap.getValue();
			try {
				storeorders1 = OrderTabale.get(storeItems1.getOrder_item_order_id());
			} catch (Exception e) {
				System.out.println("No Order ID");
				e.printStackTrace();
			}
			if (storeorders1!=null) {
				monthProductId.setYear(storeorders1.getOrder_date().getYear());
				monthProductId.setMonth(storeorders1.getOrder_date().getMonth());
				monthProductId.setProductId(storeItems1.getOrder_item_product_id());


				if(TotalSalesPerMonthPerProduct.containsKey(monthProductId)){
					count =  TotalSalesPerMonthPerProduct.get(monthProductId);
					count =count+1;
					TotalSalesPerMonthPerProduct.put(monthProductId,count);
					monthProductId = new MonthProductId(-1, -1, 999999);
				}
				else
				{ 
					TotalSalesPerMonthPerProduct.put(monthProductId, 1);
					monthProductId = new MonthProductId(-1, -1, 999999);
				}

			}
		}

		//Top Ten Product finding
		TreeMap< Integer,MonthProductId> TopTenProductPerMonth	= new TreeMap<Integer, MonthProductId>();
		monthProductId = new MonthProductId(-1, -1, 999999);
		for(Map.Entry m:TotalSalesPerMonthPerProduct.entrySet()){  
			monthProductId = (MonthProductId) m.getKey();
			TopTenProductPerMonth.put((Integer) m.getValue(), monthProductId);

		}

		TopTenProductPerMonth.size();
		monthProductId = new MonthProductId(-1, -1, 999999);
		Products_Obj products_Obj =null;
		int test=TopTenProductPerMonth.size();

		for (int i = 0;i<test-5; i++) {
			TopTenProductPerMonth.remove(TopTenProductPerMonth.firstKey());
		}

		int Year;
		int Mon;
		
		for(Map.Entry m:TopTenProductPerMonth.entrySet()){  
			monthProductId = (MonthProductId) m.getValue();
			products_Obj= ProductsTable.get(monthProductId.getProductId());
			Year=(monthProductId.getYear()+1900);
			Mon=monthProductId.getMonth();
		   System.out.println("Product Details\n"+products_Obj.getProduct_name()+"   Price-->" +products_Obj.getProduct_price()+ 
				   "  SalesCount "+m.getKey() +" for Year "+Year +" on "+Month.theMonth(Mon)+" Month");

		}


	}
}


