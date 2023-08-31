package com.java.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
	public static void main(String[] args){
		File f1 = new File("D:/infinitejava/Day 6/EmployProject/src/com/java/employ/Employ.java");
		try {
			FileReader fr = new FileReader(f1);
			int ch;
			while((ch=fr.read()) != -1){
				System.out.print((char)ch);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
