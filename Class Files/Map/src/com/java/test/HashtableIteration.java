package com.java.test;

import java.util.Hashtable;
import java.util.Map;

public class HashtableIteration {
    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("One", 1);
        hashtable.put("Two", 2);
        hashtable.put("Three", 3);

        hashtable.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }
}
