package file.handling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.InflaterInputStream;

public class UnCompress {

	public static void main(String[] args) {
		  
		try{  
		FileInputStream fin=new FileInputStream("staging/abc_compress.dfl");  
		InflaterInputStream in=new InflaterInputStream(fin);  
		  
		FileOutputStream fout=new FileOutputStream("staging/abc_uncompress.txt");  
		  
		int i;  
		while((i=in.read())!=-1){  
		fout.write((byte)i);  
		fout.flush();  
		}  
		  
		fin.close();  
		fout.close();  
		in.close();  
		  
		}catch(Exception e){System.out.println(e);}  
		System.out.println("rest of the code");  
		}  
		}