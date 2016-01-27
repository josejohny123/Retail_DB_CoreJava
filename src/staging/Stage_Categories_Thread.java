package staging;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mySql.dBStage.exeQuery;
import retail.tables.objects.Categories_Obj;

public class Stage_Categories_Thread implements Runnable {

	@Override
	public void run() {
		//Querying Categories Table
		ResultSet rs;
		String Query1 ="select * from categories";
		exeQuery QueryObject = new exeQuery();
		rs = QueryObject.selectQuery(Query1);
		List<Categories_Obj> Categories_Table = new ArrayList<Categories_Obj>();
	
			try {
				while (rs.next()){
						
					Categories_Table.add(new Categories_Obj(rs.getInt(1), rs.getInt(2), rs.getString(3)));
				}
				//Writing Orders data to Table
				FileOutputStream fo = new FileOutputStream("staging/staged_categories");
				ObjectOutputStream oobj = new ObjectOutputStream(fo);

				for (Categories_Obj categories_Obj : Categories_Table) {
					oobj.writeObject(categories_Obj);
				}
						
				oobj.flush();
				oobj.close();
				fo.close();
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		System.out.println("Success Categories Table");
	}

}
