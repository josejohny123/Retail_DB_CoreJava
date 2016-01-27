package staging;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mySql.dBStage.exeQuery;
import retail.tables.objects.Products_Obj;

public class Stage_Products_Thread implements Runnable {

	@Override
	public void run() {
		try {
			//Querying Products Table
					ResultSet rs;
					String Query1 ="select * from products where product_id <10";
					exeQuery QueryObject = new exeQuery();
					rs = QueryObject.selectQuery(Query1);
					List<Products_Obj> Products_Table = new ArrayList<Products_Obj>();
					while (rs.next()){
					Products_Table.add(new Products_Obj(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getString(6)));
					}
					//Writing Products data to Table
					FileOutputStream fo = new FileOutputStream("staging/staged_products");
					ObjectOutputStream oobj = new ObjectOutputStream(fo);
					
					for (Products_Obj products_Obj : Products_Table) {
						oobj.writeObject(products_Obj);
						
						//System.out.println(products_Obj);
						}
					oobj.flush();
					oobj.close();
					fo.close();
					
					System.out.println("Success Products");
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
