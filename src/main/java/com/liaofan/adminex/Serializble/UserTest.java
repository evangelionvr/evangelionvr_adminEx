package com.liaofan.adminex.Serializble;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class UserTest implements Serializable {

    public static void test() {
        File file = new File("Z:/user.dat");
        if (!file.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            User user = (User) ois.readObject();
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test();
    }


  //近邻算法，比较两个数组的相似度
    @Test
    public void test1() {
        String[] str1 = {"1", "2", "3", "45", "5"};
        String[] str2 = {"1", "2", "3", "4", "5","6" };
        int count = 0;
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if (str1[i].equals(str2[j])) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
