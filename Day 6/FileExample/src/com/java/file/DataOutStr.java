package com.java.file;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutStr {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("D:/infinitejava/Day 6/FileExample/src/com/java/file/files/DataOutStr.txt");
			DataOutputStream dout = new DataOutputStream(fout);
			
			dout.writeInt(10);
			dout.writeUTF("Rahul");
			dout.writeDouble(4586.52);
			dout.writeBoolean(true);
			dout.close();
			fout.close();
			System.out.println("Object Saved");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
