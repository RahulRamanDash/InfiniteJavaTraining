
package com.java.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutStrEx {
	public static void main(String[] args) {
		
		try {
			FileInputStream src = new FileInputStream("D:/infinitejava/Day 6/FileExample/src/com/java/file/files/Employcopy.txt");
			
			FileOutputStream tgt = new FileOutputStream("D:/infinitejava/Day 6/FileExample/src/com/java/file/files/Employcopy1.txt");
			int ch;
			while((ch=src.read()) != -1){
				tgt.write((char)ch);
			}

			
			src.close();
			tgt.close();
			System.out.println("***Data Copied to file***");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
