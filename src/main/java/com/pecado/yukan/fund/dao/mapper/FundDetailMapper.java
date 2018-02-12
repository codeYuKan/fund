package com.pecado.yukan.fund.dao.mapper;

import com.pecado.yukan.fund.dao.entity.FundDetail;

public interface FundDetailMapper {
    int insert(FundDetail record);

    int insertSelective(FundDetail record);
}