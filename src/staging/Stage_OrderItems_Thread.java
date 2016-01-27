package staging;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mySql.dBStage.exeQuery;
import retail.tables.objects.OrderItems_Obj;

public class Stage_OrderItems_Thread implements Runnable  {

	@Override
	public void run() {
		//Querying Orders Table
		ResultSet rs;
		String Query1 ="select * from order_items";
		exeQuery QueryObject = new exeQuery();
		rs = QueryObject.selectQuery(Query1);
		List<OrderItems_Obj> OrderItems_Table = new ArrayList<OrderItems_Obj>();
	
			try {
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
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		System.out.println("Success Order Items");
	}

}
