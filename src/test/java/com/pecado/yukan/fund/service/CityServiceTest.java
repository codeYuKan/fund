package com.pecado.yukan.fund.service;

import com.pecado.yukan.fund.FundApplicationTests;
import com.pecado.yukan.fund.dao.entity.City;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CityServiceTest extends FundApplicationTests {

    @Autowired
    private CityService cityService;

    @Test
    public void testSelectByPrimaryKey(){
        try {
            City city = cityService.selectByPrimaryKey(1);
            System.out.println(city);
        } catch (Exception e){
            System.out.println("");
        }
    }
}
