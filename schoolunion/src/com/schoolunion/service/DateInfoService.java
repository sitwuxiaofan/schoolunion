package com.schoolunion.service;

import com.schoolunion.po.Custom.TDateInfoCustom;

public interface DateInfoService {
	//插入当天日期到日期表中
	public int insertDate(TDateInfoCustom tDateInfoCustom) throws Exception;
	//插入当天日期到日期表中
	public int deleteDate(TDateInfoCustom tDateInfoCustom) throws Exception;
}
