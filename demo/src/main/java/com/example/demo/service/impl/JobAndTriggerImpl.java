package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.JobAndTriggerMapper;
import com.example.demo.entity.JobAndTrigger;
import com.example.demo.job.HelloJob;
import com.example.demo.service.IJobAndTriggerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class JobAndTriggerImpl implements IJobAndTriggerService{
	private static Logger _log = LoggerFactory.getLogger(HelloJob.class);  

	@Autowired
	private JobAndTriggerMapper jobAndTriggerMapper;
	
	public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<JobAndTrigger> list = jobAndTriggerMapper.getJobAndTriggerDetails();
		PageInfo<JobAndTrigger> page = new PageInfo<JobAndTrigger>(list);
		return page;
	}

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		 _log.error("doSomething Job执行时间: " + new Date());  
	}

}