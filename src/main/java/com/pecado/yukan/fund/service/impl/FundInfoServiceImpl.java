package com.pecado.yukan.fund.service.impl;

import com.pecado.yukan.fund.dao.entity.FundInfo;
import com.pecado.yukan.fund.dao.mapper.FundInfoMapper;
import com.pecado.yukan.fund.service.FundInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yukan
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FundInfoServiceImpl implements FundInfoService {

    @Autowired
    private FundInfoMapper fundInfoMapper;

    /**
     * 根据主键查找
     */
    @Override
    public List<FundInfo> findList() {
        return fundInfoMapper.findList();
    }
}
