package file.handling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile_Read {

	public static void main(String[] args) throws IOException {
		 FileReader fr=new FileReader("staging/abc.txt");  
		  int i;  
		  while((i=fr.read())!=-1)  
		  System.out.println((char)i);  
		  
		  fr.close();  
		 }  
		}  