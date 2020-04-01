package com.jiang.day3;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;

public class pratice {
    @BeforeTest
    public void test(){
        System.out.println("++++++++++++++++++++++++++++++");
    }
    @Test
    public void test_01(){
        System.out.println("hello word");
    }
    @AfterTest
    public void AterTest(){
        System.out.println("================================");
    }

//
//    public void creade_file() throws IOException {
//        File file = new File("F:/IdeaProjects/File/filename.txt");
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//        FileWriter fw = null;
//        try {
//            fw = new FileWriter(file);
//            fw.append("卡卡卡卡卡");
//            fw.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (null != fw)
//                fw.close();
//        }
//    }
//
//    public void read_file() throws IOException {
//        File file = new File("F:/IdeaProjects/File/filename.txt");
//        FileReader fileReader = new FileReader(file);
//        BufferedReader bf = new BufferedReader(fileReader);
//        String str;
//        while ((str = bf.readLine()) != null) {
//            System.out.println(str);
//        }
//        fileReader.close();
//    }
}