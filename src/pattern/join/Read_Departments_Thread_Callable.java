package pattern.join;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.concurrent.Callable;

import retail.tables.objects.Departments_Obj;

import com.sun.corba.se.impl.io.OptionalDataException;

public class Read_Departments_Thread_Callable implements Callable {

	HashMap<Integer, Departments_Obj> DepartmentsTabale = new HashMap<Integer,Departments_Obj>();
	InputStream fin;
	ObjectInputStream objin;
	

	
	@Override
	public HashMap<Integer, Departments_Obj> call() throws Exception {
		

    	
		
		try {
			fin = new FileInputStream("staging/staged_departments");
			
			objin = new ObjectInputStream(fin);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Departments_Obj store;


		boolean doneReadingFile =false;
		//Reading Objects from the file
		while(!doneReadingFile){

			try {
				store = (Departments_Obj) objin.readObject();

				DepartmentsTabale.put(store.getDepartment_id(), store);
			} catch (EOFException eofe) {
				doneReadingFile=true;
				System.out.println("File Read complete1");
//				for(Map.Entry orderitemsmap:DepartmentsTabale.entrySet()){
//					
//					System.out.println(orderitemsmap.getValue());
//				}
				try {
					fin.close();
					objin.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			catch (OptionalDataException ode) {
				doneReadingFile=ode.eof;
				System.out.println("File Data Exception");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//		for(Map.Entry orderitemsmap:DepartmentsTabale.entrySet()){
		//			
		//			System.out.println(orderitemsmap.getValue());
		//		}

		
	
		return DepartmentsTabale;
	}
	
	
}
