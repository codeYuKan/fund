package com.pecado.yukan.fund.demo;

import java.io.*;

/**
 * @author yukan
 * @date 2018/2/12
 * @email yukan.cn.mail@gmail.com
 */
public class IODemo {

    final static Integer SIZE = 1024;

    public static void main(String[] args) throws IOException{
        FileInputStream in = null;
        FileOutputStream out = null;

        Reader reader = null;
        BufferedReader bufferedReader = null;

        int tempChar;
        String tempStr;

        int len;
        byte[] buf = new byte[SIZE];
        char[] chars = new char[SIZE];
        try {
            in = new FileInputStream("../../test.txt");
            System.out.println(in.available());
            /**
             * 按行读
             * 以行为单位读取文件，常用于读面向行的格式化文件
             */
            bufferedReader = new BufferedReader(new FileReader(new File("../../test.txt")));
            while ((tempStr = bufferedReader.readLine()) != null){
                System.out.println(tempStr);
            }
            /**
             * 字符读取
             * 以字符为单位读取文件，常用于读文本，数字等类型的文件
             */
//            reader = new InputStreamReader(in);
//            while((len = reader.read(chars)) != -1){
//                System.out.println(new String(chars, 0, len));
//            }

            /**
             * 字节读取
             * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
             */
//            while ((len = in.read(buf)) != -1){
//                //, "UTF-8"
//                System.out.println(new String(buf, 0, len));
//            }
//            System.out.println("*****************************");
//            while ((tempChar = in.read()) != -1){
//                System.out.println(tempChar);
//            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

}