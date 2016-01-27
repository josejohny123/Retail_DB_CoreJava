package staging;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mySql.dBStage.exeQuery;
import retail.tables.objects.Departments_Obj;
import retail.tables.objects.OrderItems_Obj;

public class Stage_Departments_Thread implements Runnable {

	@Override
	public void run() {
		//Querying Departments Table
				ResultSet rs;
				String Query1 ="select * from departments";
				exeQuery QueryObject = new exeQuery();
				rs = QueryObject.selectQuery(Query1);
				List<Departments_Obj> Departments_Table = new ArrayList<Departments_Obj>();
			
					try {
						while (rs.next()){
								
							Departments_Table.add(new Departments_Obj(rs.getInt(1), rs.getString(2)));
						}
						//Writing Orders data to Table
						FileOutputStream fo = new FileOutputStream("staging/staged_departments");
						ObjectOutputStream oobj = new ObjectOutputStream(fo);

						for (Departments_Obj departments_Obj : Departments_Table) {
							oobj.writeObject(departments_Obj);
						}
								
						oobj.flush();
						oobj.close();
						fo.close();
					} catch (SQLException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				

				System.out.println("Success Departments Table");
	}

}
