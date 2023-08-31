package com.java.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileDemo1 {
	public static void main(String[] args) throws FileNotFoundException {
		File f1 = new File("D:/infinitejava/Day 6/EmployProject/src/com/java/employ/Employ.java");
		System.out.println("File Name"+f1.getName());
		System.out.println("Parent"+f1.getParent());
		System.out.println("Path"+f1.getPath());
	}

}
