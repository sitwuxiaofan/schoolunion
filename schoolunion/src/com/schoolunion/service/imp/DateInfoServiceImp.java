package com.schoolunion.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolunion.mapper.Custom.TDateInfoCustomMapper;
import com.schoolunion.po.Custom.TDateInfoCustom;
import com.schoolunion.service.DateInfoService;


@Service
public class DateInfoServiceImp implements DateInfoService{

	@Autowired
	private TDateInfoCustomMapper tDateInfoCustomMapper;
	
	@Override
	public int insertDate(TDateInfoCustom tDateInfoCustom) throws Exception {
		return tDateInfoCustomMapper.insertDate(tDateInfoCustom);
	}

	@Override
	public int deleteDate(TDateInfoCustom tDateInfoCustom) throws Exception {
		return tDateInfoCustomMapper.deleteDate(tDateInfoCustom);
	}

}
