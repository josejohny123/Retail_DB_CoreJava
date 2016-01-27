package staging;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mySql.dBStage.exeQuery;
import retail.tables.objects.Customers_Obj;

public class Stage_Customers_Thread implements Runnable {

	@Override
		public void run() {
			//Querying Customers Table
					ResultSet rs;
					String Query1 ="select * from customers";
					exeQuery QueryObject = new exeQuery();
					rs = QueryObject.selectQuery(Query1);
					List<Customers_Obj> Customers_Table = new ArrayList<Customers_Obj>();
				
						try {
							while (rs.next()){
									
								Customers_Table.add(new Customers_Obj(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
							}
							//Writing Orders data to Table
							FileOutputStream fo = new FileOutputStream("staging/staged_customers");
							ObjectOutputStream oobj = new ObjectOutputStream(fo);

							for (Customers_Obj customers_Obj : Customers_Table) {
								oobj.writeObject(customers_Obj);
							}
									
							oobj.flush();
							oobj.close();
							fo.close();
						} catch (SQLException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					

					System.out.println("Success Customers Table");
	}

}
