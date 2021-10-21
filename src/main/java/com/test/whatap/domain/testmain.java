package com.test.whatap.domain;

import com.test.whatap.database.FilePath;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class testmain {
    public static void main(String[] args) {
        try {
//            File file = new File(FilePath.PRODUCT_PATH + "/test");
//            RandomAccessFile raf = new RandomAccessFile(file, "rw");
//
//            raf.writeInt(100);
//            raf.writeUTF("ㅋㅋㅋㅋㅋㅋ");
//            raf.writeInt(200);
//            raf.writeUTF("ㅎㅎㅎㅎㅎㅎ");
//
//
//
//            Map<String,Integer> nodeMap = new HashMap<>();
//
//            if(nodeMap.containsKey(200)) {
//                raf.seek(nodeMap.get(200));
//                System.out.println("길이 : " + raf.length());
//                raf.seek(0);
//                System.out.println("0 : " + raf.readInt());
//                System.out.println("1 : " + raf.readUTF());
//                System.out.println("2 : " + raf.readInt());
//                System.out.println("1 : " + raf.readUTF());
//            }
//            raf.seek(1);
//            System.out.println("1 UTF : " + raf.readInt());
//            raf.seek(3);
//            System.out.println("3 : " + raf.readInt());

//            raf.close();


            RandomAccessFile raf = null;
            Scanner sc = new Scanner(System.in);
//            int idx = 1019;

            while(true) {
                System.out.println("id : ");
                int id = sc.nextInt();
//                System.out.println("name : ");
//                String name = sc.next();
//                System.out.println("parent : ");
//                int parent = sc.nextInt();
//                System.out.println("tier : ");
//                int tier = sc.nextInt();




                File file = new File(FilePath.CATEGORY_PATH + id);
                raf = new RandomAccessFile(file, "rw");
                raf.seek(4);
                String name = raf.readUTF();
                int parent = raf.readInt();
                int tier = raf.readInt();


                raf.seek(0);
                raf.writeInt(id);
                raf.writeInt(parent);
                raf.writeInt(tier);
                raf.writeUTF(name);
            }
//                idx++;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
