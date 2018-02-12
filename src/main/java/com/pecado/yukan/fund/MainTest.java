package com.pecado.yukan.fund;

import com.pecado.yukan.fund.util.HttpUtil;

import java.util.*;

/**
 * @author yukan
 * @date 2018/2/11
 * @email yukan.cn.mail@gmail.com
 */
public class MainTest {

    public static void main(String[] args) {
        String url = "http://fund.eastmoney.com/f10/F10DataApi.aspx";
        Map<String, String> params = new HashMap<>(8);
        params.put("type","lsjz");
        params.put("code","161631");
        params.put("page","1");
        params.put("per","1000");
        params.put("sdate","");
        params.put("edate","");
        String getResult = HttpUtil.get(url, params);
        System.out.println(getResult);
        String data = getResult.split("<tbody>")[1];
        data = data.split("</tbody>")[0];
        data = data.replaceAll(" class='tor bold'", "");
        data = data.replaceAll(" class='tor bold grn'", "");
        data = data.replaceAll(" class='red unbold'", "");
        data = data.replaceAll(" class='tor bold'", "");
        data = data.replaceAll(" class='tor bold red'", "");
        data = data.replaceAll(" class='tor bold bck'", "");
        System.out.println(data);
        data = data.replaceAll("</td></tr><tr><td>", "&");
        data = data.replaceAll("</td><td>", ",");
        data = data.replaceAll("<tr><td>", "");
        data = data.replaceAll("</td></tr>", "");
        System.out.println(data);
        List<String> list = Arrays.asList(data.split("&"));
        System.out.println(list);
        List<String> l;
        for (String str : list){
            l = Arrays.asList(str.split(","));
            System.out.println(l.size());
            for (String s : l){
                System.out.println(s);
            }
        }
        System.exit(0);
    }
}
