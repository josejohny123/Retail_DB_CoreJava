package mySql.dBStage;

import java.sql.ResultSet;
import java.sql.SQLException;

//import mySql.dBStage.exeQuery;

public class TestQuery {

	public static void main(String[] args) {
		
		ResultSet rs;
		String Query1 ="select * from products where product_id <10";
		exeQuery QueryObject = new exeQuery();
		rs = QueryObject.selectQuery(Query1);
		try {
			while (rs.next()){
				System.out.println(rs.getInt(1)+rs.getInt(2)+rs.getString(3)+rs.getString(4)+rs.getFloat(5)+rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
