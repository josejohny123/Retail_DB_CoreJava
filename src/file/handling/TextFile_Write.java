package file.handling;

import java.io.FileWriter;

public class TextFile_Write {

	public static void main(String[] args) {
		 try{  
			   FileWriter fw=new FileWriter("staging/abc.txt");  
			   fw.write("my name is Jose");  
			   fw.close();  
			  }catch(Exception e){System.out.println(e);}  
			  System.out.println("success");  
			 }  
			}  