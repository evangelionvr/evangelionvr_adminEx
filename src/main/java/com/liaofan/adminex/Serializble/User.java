package com.liaofan.adminex.Serializble;

import lombok.Data;
import lombok.val;
import org.junit.Test;

import java.io.*;
import java.util.Base64;

import static java.lang.Thread.sleep;

@Data
public class User implements java.io.Serializable {

    private static final long serialVersionUID = 1L;


    private String name;
    private String password;
    private String email;
    private String phone;
    private String address;

    public User() {

    }

    public User(String name, String password, String email, String phone, String address) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    private void writeObject(java.io.ObjectOutputStream stream) throws java.io.IOException {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] bytes = encoder.encode(this.name.getBytes());
        this.name = new String(bytes);
        stream.defaultWriteObject();     // 调用父类的writeObject()方法
    }


    private void readObject(java.io.ObjectInputStream stream) throws java.io.IOException, ClassNotFoundException {
        stream.defaultReadObject();     // 调用父类的readObject()方法
        //Base64.Decoder decoder = Base64.getDecoder();
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(this.name);
        this.name = new String(decoder.decode(bytes));
    }


    public static void main(String[] args) {
        User user = new User("liaofan", "123456", "evangelion@163.com", "18888888888", "China");

        File file = new File("Z:/user.dat");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("文件创建失败");
                return;
            }
        }

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file, false));
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        test();





    }

    @Test
    public static void test() {
        //User user = new User("liaofan", "123456", "evangelion@163.com", "18888888888", "China");
        File file = new File("Z:/user.dat");
        if (!file.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            User user = (User) ois.readObject();
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
