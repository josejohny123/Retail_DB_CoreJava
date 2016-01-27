package staging;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Stage_Tables {

	public static void main(String[] args) throws InterruptedException {
	

		Stage_OrderItems_Thread orderItems = new Stage_OrderItems_Thread();
		Stage_Orders_Thread orders = new Stage_Orders_Thread();
		Stage_Products_Thread  products = new Stage_Products_Thread();
		Stage_Categories_Thread categories = new Stage_Categories_Thread();
		Stage_Customers_Thread customers = new Stage_Customers_Thread();
		Stage_Departments_Thread departments = new Stage_Departments_Thread();
		
		Thread orderitemsThread = new Thread(orderItems);
		Thread ordersThread = new Thread(orders);
		Thread productsThread = new Thread(products);
		
		orderitemsThread.start();
		ordersThread.start();
		productsThread.start();
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		executor.submit(categories);
		executor.submit(customers);
		executor.submit(departments);
		
		 executor.shutdown();
		 executor.awaitTermination(3,TimeUnit.MINUTES);
	}

}
