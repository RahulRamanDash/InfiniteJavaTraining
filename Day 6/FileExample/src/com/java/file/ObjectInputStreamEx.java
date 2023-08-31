package com.java.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Date;

public class ObjectInputStreamEx {
	public static void main(String[] args) {
		try {
			FileInputStream src = new FileInputStream("D:/infinitejava/Day 6/FileExample/src/com/java/file/files/D.txt");
			ObjectInputStream objin = new ObjectInputStream(src);
			String str =(String)objin.readObject();
			Date date = (Date)objin.readObject();
			objin.close();
			src.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	
	}

}
