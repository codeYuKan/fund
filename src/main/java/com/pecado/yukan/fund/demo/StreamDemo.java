package com.pecado.yukan.fund.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yukan
 * @date 2018/2/11
 * @email yukan.cn.mail@gmail.com
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("221");
        list.add("322");
        list.add("4112");
        list.add("112");
        System.out.println(list);
        list = list.stream().filter(str -> str.startsWith("1")).collect(Collectors.toList());
        System.out.println(list);
    }
}
