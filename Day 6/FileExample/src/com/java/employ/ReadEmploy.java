package com.java.employ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadEmploy {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("D:/infinitejava/Day 6/FileExample/src/com/java/employ/files/EmployData.txt");
			ObjectInputStream objin = new ObjectInputStream(fis);
			Employ employ = (Employ)objin.readObject();
			System.out.println(employ);
			
			objin.close();
			fis.close();
		} catch (FileNotFoundException e) {
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
