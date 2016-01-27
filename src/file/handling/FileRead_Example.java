package file.handling;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class FileRead_Example {

	public static void main(String[] args) {
		try{  
		    FileInputStream fin=new FileInputStream("staging/f1.txt");  
		    BufferedInputStream bin=new BufferedInputStream(fin);  
		    int i;  
		    while((i=bin.read())!=-1){  
		     System.out.println((char)i);  
		    }  
		    bin.close();  
		    fin.close();  
		  }catch(Exception e){System.out.println(e);}  
		 }  
		}  