package com.java.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
	public static void main(String[] args) {
		File f1 = new File("D:/infinitejava/Day 6/FileExample/src/com/java/file/FileWriterEx.txt");
		
		try {
			FileWriter fw = new FileWriter(f1);
			fw.write("Hello World");
			fw.close();
			System.out.println("Data saved in file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
