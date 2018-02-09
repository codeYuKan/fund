package com.pecado.yukan.fund.demo;

import java.io.*;
import java.util.*;

public class DemoTest {


    private List<String> findMostFrequentTwoLabels(String evaluateLabels){
        String[] labelArray = evaluateLabels.split(",");
        List<String> labelList = Arrays.asList(labelArray);
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>(16);
        for (String label : labelArray){
            Integer num = map.get(label);
            map.put(label, num == null ? 1 : num + 1);
        }
        String mostFrequentElement = findFirstKeySortedByValue(map);
        map.remove(mostFrequentElement);
        result.add(mostFrequentElement);
        result.add(findFirstKeySortedByValue(map));
        return result;
    }

    private String findFirstKeySortedByValue(Map<String, Integer> map){
        return map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).findFirst().get().getKey();
    }


    public static void main(String[] args) throws IOException {
//        Test test = new Test();
//        String testString = "响应迅速,认真负责,态度很好,响应迅速,非常专业";
//        System.out.println(test.findMostFrequentTwoLabels(testString));
//        Long l = null;
//        if(l != null){
//            System.out.println("123");
//        }



        System.exit(0);
    }
}
