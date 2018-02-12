package com.pecado.yukan.fund.service;


import com.pecado.yukan.fund.dao.entity.FundInfo;

import java.util.List;

/**
 * @author yukan
 */
public interface FundInfoService {

    /**
     * 根据主键查找
     */
    List<FundInfo> findList();
}
