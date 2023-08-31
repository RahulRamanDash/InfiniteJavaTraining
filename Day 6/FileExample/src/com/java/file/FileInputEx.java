package com.java.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputEx {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("D:/infinitejava/Day 6/FileExample/src/com/java/file/files/DataOutStr.txt");
			DataInputStream din = new DataInputStream(fis);
			
			System.out.println("X value is "+din.readInt());
			System.out.println("Name is "+din.readUTF());
			System.out.println("Basic is "+din.readDouble());
			System.out.println("Boolean value is "+din.readBoolean());
			
			din.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
