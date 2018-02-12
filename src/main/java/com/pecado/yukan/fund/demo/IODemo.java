package com.pecado.yukan.fund.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author yukan
 * @date 2018/2/12
 * @email yukan.cn.mail@gmail.com
 */
public class IODemo {

    public static void main(String[] args) throws IOException{
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("../../test.txt");
            int i;
            while ((i = in.read()) != -1){
                System.out.println(i);
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

}