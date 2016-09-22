package com.schoolunion.mapper.Custom;

import com.schoolunion.po.Custom.TDateInfoCustom;

public interface TDateInfoCustomMapper {
	//插入当天日期到日期表中
	public int insertDate(TDateInfoCustom tDateInfoCustom) throws Exception;
	//插入当天日期到日期表中
	public int deleteDate(TDateInfoCustom tDateInfoCustom) throws Exception;
}