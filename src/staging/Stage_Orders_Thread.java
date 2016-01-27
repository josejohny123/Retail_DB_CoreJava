package staging;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mySql.dBStage.exeQuery;
import retail.tables.objects.Orders_Obj;

public class Stage_Orders_Thread implements Runnable {

	@Override
	public void run() {
		try {
			//Querying Orders Table
					ResultSet rs;
					String Query1 ="select * from orders";
					exeQuery QueryObject = new exeQuery();
					rs = QueryObject.selectQuery(Query1);
					List<Orders_Obj> Orders_Table = new ArrayList<Orders_Obj>();
					while (rs.next()){
						
						Orders_Table.add(new Orders_Obj(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getString(4)));
					}
					//Writing Orders data to Table
					FileOutputStream fo = new FileOutputStream("staging/staged_orders");
					ObjectOutputStream oobj = new ObjectOutputStream(fo);
					for (Orders_Obj orders_Obj : Orders_Table) {
						oobj.writeObject(orders_Obj);
					}
					
					oobj.flush();
					oobj.close();
					fo.close();

					System.out.println("Success Orders");
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
