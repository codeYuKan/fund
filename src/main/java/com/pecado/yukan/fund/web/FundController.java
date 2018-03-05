package com.pecado.yukan.fund.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yukan
 * @date 2018/3/5
 * @email yukan.cn.mail@gmail.com
 */
@Controller
@RequestMapping("/api/fund")
public class FundController {

    @RequestMapping(value = "zzz", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> test(){
        Map<String, Object> result = new HashMap<>(4);
        result.put("a","123");
        result.put("b","1234");
        return result;
    }
}
