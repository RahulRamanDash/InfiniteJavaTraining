package com.java.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyEx {
	public static void main(String[] args) {
		File src = new File("D:/infinitejava/Day 6/EmployProject/src/com/java/employ/Employ.java");
		File tgt = new File("D:/infinitejava/Day 6/FileExample/src/com/java/file/files/EmployCopy.txt");
		
		try {
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(tgt);
			int ch;
			while((ch=fr.read()) != -1){
				fw.write((char)ch);
			}
			fr.close();
			fw.close();
			System.out.println("***File Copied***");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
