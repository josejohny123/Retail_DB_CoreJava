package mySql.dBStage;

import java.sql.*;

public class MakeConnection {
	Connection con;
	Statement stmt;
	ResultSet rs;
	public MakeConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");	
		
			con = DriverManager.getConnection("jdbc:mysql://quickstart:3306/retail_db","retail_dba","cloudera");
			stmt = con.createStatement();		
			rs = stmt.executeQuery("select * from products where product_id <10");
			while (rs.next()){
				System.out.println(rs.getInt(1)+rs.getInt(2)+rs.getString(3)+rs.getString(4)+rs.getFloat(5)+rs.getString(6));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
