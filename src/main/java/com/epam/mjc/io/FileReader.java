package com.epam.mjc.io;

import java.io.*;

import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder str = new StringBuilder();
        try(FileInputStream rd = new FileInputStream(file)) { 
            int count;
            while ((count = rd.read()) != -1) {
                str.append((char)count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String st = str.toString();
       // System.out.println(st);
        String[] arr = st.split("\n");
       // System.out.println(arr.length);
        String[] m = new String[4];
          for (int i = 0; i < 4; i++) {
            String[] keyvalue = arr[i].split(":");
            m[i] = keyvalue[1].trim();
        }
        /*for (String x : m) {
            System.out.println(x);
        }*/
        
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
   /*public static void main(String[] args) {

        String directory = System.getProperty("user.dir");
        String filename = "src/main/resources/Profile.txt";
        String absolutePath = directory + File.separator + filename;
        System.out.println(getDataFromFile(new File(absolutePath)));
   }*/
}
