package com.schoolunion.Timedtask;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component(value="/Timedtask")
public class Timedtask {
	private static Logger logger = Logger.getLogger(Timedtask.class);
	
	@Autowired
	private InsertDate insertDate;
	
	@Value("${host}")
	private String host;
	
	@Scheduled(cron = "0 2 0 * * ?")//每天0点2分执行一次
	public void insertDateByTimes() throws Exception { 
		insertDate.insertDateByTimes();
		logger.info("插入日期....每天0点2分执行一次");
	}
	
}
