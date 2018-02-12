package com.pecado.yukan.fund.dao.mapper;

import com.pecado.yukan.fund.dao.entity.FundData;

public interface FundDataMapper {
    int deleteByPrimaryKey(String code);

    int insert(FundData record);

    int insertSelective(FundData record);

    FundData selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(FundData record);

    int updateByPrimaryKey(FundData record);
}