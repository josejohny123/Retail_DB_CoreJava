package file.handling;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWrite_Example {

	public static void main(String[] args) throws IOException {
		  FileOutputStream fout;
					//fout = new FileOutputStream("f1.txt");
					fout = new FileOutputStream("staging/f1.txt");
		 
		   BufferedOutputStream bout=new BufferedOutputStream(fout);  
		   String s="Hi , How Are you ?";  
		   byte b[]=s.getBytes();  
		 	bout.write(b);
		 	   		  
		   bout.flush();  
		   bout.close();  
		   fout.close();  
		   System.out.println("success");  
		 }  
		}   