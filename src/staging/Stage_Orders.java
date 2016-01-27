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

import retail.tables.objects.Orders_Obj;
import retail.tables.objects.Products_Obj;
import mySql.dBStage.exeQuery;

public class Stage_Orders {

	public static void main(String[] args) throws SQLException, IOException {

		//Querying Orders Table
		ResultSet rs;
		String f1 = "2014-07-01";
		String f2 = "2014-07-31";
		String Query1 ="select * from orders where order_date>='"+f1+"' and order_date <='"+f2+"'";
		exeQuery QueryObject = new exeQuery();
		rs = QueryObject.selectQuery(Query1);
		List<Orders_Obj> Orders_Table = new ArrayList<Orders_Obj>();
//		System.out.println(rs.next());
		while (rs.next()){
			
			Orders_Table.add(new Orders_Obj(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getString(4)));
		}
		//Writing Orders data to Table
		FileOutputStream fo = new FileOutputStream("staging/staged_orders");
		ObjectOutputStream oobj = new ObjectOutputStream(fo);
		for (Orders_Obj orders_Obj : Orders_Table) {
			oobj.writeObject(orders_Obj);
//			System.out.println(orders_Obj);
		}
		
		oobj.flush();
		oobj.close();
		fo.close();

		System.out.println("Success");
	}}

