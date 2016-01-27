package mySql.dBStage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;


	public class exeQuery {
		Connection con;
		Statement stmt;
		ResultSet rs;
		String sqlQuery;
		
		public ResultSet selectQuery(String sqlQuery) {
			try {
				this.sqlQuery=sqlQuery;
				Class.forName("com.mysql.jdbc.Driver");	
				con = DriverManager.getConnection("jdbc:mysql://quickstart:3306/retail_db","retail_dba","cloudera");
				stmt = con.createStatement();		
				rs = stmt.executeQuery(sqlQuery);
				//while (rs.next()){
					//System.out.println(rs.getInt(1)+rs.getInt(2)+rs.getString(3)+rs.getString(4)+rs.getFloat(5)+rs.getString(6));
					//
					
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return rs;
		}
		
	}

