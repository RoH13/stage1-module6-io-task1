package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String str = "";
        try {
            str = Files.readString(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arr = str.split("\n");
        String[] m = new String[4];
        for (int i = 0; i < 4; i++) {
            String[] keyvalue = arr[i].split(":");
            m[i] = keyvalue[1];
        }
        int age;
        try {
            age= Integer.parseInt(m[1]);
        } catch (NumberFormatException e) {
            age = 0;
        }
        long t;
        try {
            t = Long.parseLong(m[3]);
        } catch (NumberFormatException e) {
            t = 0;
        }
        return new Profile(m[0], age, m[2], t);
    }
   public static void main(String[] args) {
    getDataFromFile("Profile.txt");
   }
}
