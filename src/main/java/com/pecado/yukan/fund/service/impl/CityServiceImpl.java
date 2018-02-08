package com.pecado.yukan.fund.service.impl;

import com.pecado.yukan.fund.dao.entity.City;
import com.pecado.yukan.fund.dao.mapper.CityMapper;
import com.pecado.yukan.fund.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yukan
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public City selectByPrimaryKey(Integer id) {
        return cityMapper.selectByPrimaryKey(id);
    }
}
