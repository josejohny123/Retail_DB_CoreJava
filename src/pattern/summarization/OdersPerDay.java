package pattern.summarization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import retail.tables.objects.Orders_Obj;
import retail.tables.objects.Products_Obj;

import com.sun.corba.se.impl.io.OptionalDataException;

public class OdersPerDay {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		InputStream fin =new FileInputStream("staging/staged_orders");
		ObjectInputStream objin = new ObjectInputStream(fin);
		int i;
		ArrayList<Orders_Obj> Orders_Stage = new ArrayList<Orders_Obj>();
		boolean doneReadingFile =false;
		//Reading Objects from the file
		while(!doneReadingFile){

			try {
				Orders_Stage.add((Orders_Obj) objin.readObject());
			} catch (EOFException eofe) {
				doneReadingFile=true;
				System.out.println("File Read complete1");
			}
			catch (OptionalDataException ode) {
				doneReadingFile=ode.eof;
				System.out.println("File Data Exception");
			}

		}
		//Orders Per Day logic
		Timestamp day;
		Integer count = new Integer(0);
		
	      TreeMap<Timestamp,Integer> ordersPerDay=new TreeMap<Timestamp, Integer>() ;
	   
	      for (Orders_Obj orders_Obj : Orders_Stage) {
	    	//  System.out.println(orders_Obj);
	    	  day = orders_Obj.getOrder_date();
	    	  if(ordersPerDay.get(day) != null){
	    		  count= ordersPerDay.get(day);
		    	   ordersPerDay.put(day, count+1); 		  
	    	  }
	    	  else{
	    		  ordersPerDay.put(day,1);
	    	 
	    	  }
	    	   	    	   
		}
	      for(Map.Entry m:ordersPerDay.entrySet()){  
	    	   System.out.println(m.getKey()+" "+m.getValue());  
	    	  }  
		
		}
		
	}
