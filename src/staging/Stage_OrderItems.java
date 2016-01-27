package staging;

		import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import retail.tables.objects.OrderItems_Obj;
		import retail.tables.objects.Orders_Obj;
import retail.tables.objects.Products_Obj;
import mySql.dBStage.exeQuery;

		public class Stage_OrderItems {

			public static void main(String[] args) throws SQLException, IOException {

				//Querying Orders Table
				ResultSet rs;
				String Query1 ="select * from order_items";
				exeQuery QueryObject = new exeQuery();
				rs = QueryObject.selectQuery(Query1);
				List<OrderItems_Obj> OrderItems_Table = new ArrayList<OrderItems_Obj>();
				while (rs.next()){
						
					OrderItems_Table.add(new OrderItems_Obj(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6)));
				}
				//Writing Orders data to Table
				FileOutputStream fo = new FileOutputStream("staging/staged_orderItems");
				ObjectOutputStream oobj = new ObjectOutputStream(fo);
			
				for (OrderItems_Obj orderItems_Obj : OrderItems_Table) {
					oobj.writeObject(orderItems_Obj);
				}
						
				oobj.flush();
				oobj.close();
				fo.close();

				System.out.println("Success");
			}}
