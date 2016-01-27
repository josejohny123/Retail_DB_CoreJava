package file.handling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;

public class Compress {

	public static void main(String[] args) {
		try{  
			FileInputStream fin=new FileInputStream("staging/abc.txt");  
			  
			FileOutputStream fout=new FileOutputStream("staging/abc_compress.dfl");  
			FileOutputStream foutGzip =new FileOutputStream("staging/abc_Gzipcompress.gz");  
			DeflaterOutputStream out=new DeflaterOutputStream(fout);  
			GZIPOutputStream outGzip = new GZIPOutputStream(foutGzip) ;
			int i;  
			while((i=fin.read())!=-1){  
			out.write((byte)i);  
			outGzip.write((byte)i);
			out.flush(); 
			outGzip.flush();
			}  
			  
			fin.close();  
			out.close();  
			outGzip.close();
			  
			}catch(Exception e){System.out.println(e);}  
			System.out.println("rest of the code");  
			}  
			}  