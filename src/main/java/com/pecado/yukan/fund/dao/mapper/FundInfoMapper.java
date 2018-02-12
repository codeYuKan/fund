package com.pecado.yukan.fund.dao.mapper;

import com.pecado.yukan.fund.dao.entity.FundInfo;

import java.util.List;

public interface FundInfoMapper {
    int insert(FundInfo record);

    int insertSelective(FundInfo record);

    List<FundInfo> findList();
}