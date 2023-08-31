package com.java.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStrEx {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("D:/infinitejava/Day 6/FileExample/src/com/java/file/files/Employcopy.txt");
			int ch;
			while((ch=fis.read()) != -1){
				System.out.print((char)ch);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
