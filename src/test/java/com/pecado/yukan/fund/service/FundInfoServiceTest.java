package com.pecado.yukan.fund.service;

import com.pecado.yukan.fund.FundApplicationTests;
import com.pecado.yukan.fund.dao.entity.FundInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FundInfoServiceTest extends FundApplicationTests {

    @Autowired
    private FundInfoService fundInfoService;

    @Test
    public void testFindList(){
            List<FundInfo> list = fundInfoService.findList();
            System.out.println(list);
    }
}
