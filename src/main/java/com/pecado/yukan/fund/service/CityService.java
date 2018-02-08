package com.pecado.yukan.fund.service;

import com.pecado.yukan.fund.dao.entity.City;

/**
 * @author yukan
 */
public interface CityService {

    /**
     * 根据主键查找
     */
    City selectByPrimaryKey(Integer id);
}
