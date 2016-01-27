package file.handling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

public class UnCompress_Gzip {
	
	public static void main(String[] args) {
		  
	try{  
	FileInputStream fin=new FileInputStream("staging/abc_Gzipcompress.gz"); 
	
	//InflaterInputStream in=new InflaterInputStream(fin);  
	GZIPInputStream in_gunzip   = new GZIPInputStream(fin);
	
	//FileOutputStream fout=new FileOutputStream("staging/abc_uncompress.txt");  
	FileWriter fw = new FileWriter("staging/abc_gunzip_uncompress.txt") ;
	
	int i;  
	while((i=in_gunzip.read())!=-1){  
	//fout.write((byte)i);  
	//fout.flush();  
	fw.write((byte)i);
	fw.flush();
	}  
	  
	fin.close();  
	//fout.close();  
	//in.close();  
	  fw.close();
	  in_gunzip.close();
	}catch(Exception e){System.out.println(e);}  
	System.out.println("rest of the code");  
	}  
}