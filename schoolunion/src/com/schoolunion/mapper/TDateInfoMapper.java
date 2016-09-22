package com.schoolunion.mapper;

import com.schoolunion.po.TDateInfo;

public interface TDateInfoMapper {

    int deleteByPrimaryKey(Integer datepk);

    int insert(TDateInfo record);

    int insertSelective(TDateInfo record);


    TDateInfo selectByPrimaryKey(Integer datepk);

    int updateByPrimaryKeySelective(TDateInfo record);

    int updateByPrimaryKey(TDateInfo record);
}