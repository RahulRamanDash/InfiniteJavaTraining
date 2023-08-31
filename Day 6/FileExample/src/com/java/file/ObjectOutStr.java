package com.java.file;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutStr {
	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("D:/infinitejava/Day 6/FileExample/src/com/java/file/files/ObjectOutStr.txt");
			ObjectOutputStream dout = new ObjectOutputStream(fout);
			
			dout.writeObject("rahul");;
			dout.close();
			fout.close();
			System.out.println("Data Saved");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
