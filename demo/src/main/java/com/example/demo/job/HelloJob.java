package com.example.demo.job;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.IJobAndTriggerService;  
  
public class HelloJob implements BaseJob {  
  
    private static Logger _log = LoggerFactory.getLogger(HelloJob.class);  
     
    @Autowired
	private IJobAndTriggerService iJobAndTriggerService;
    
    public HelloJob() {  
          
    }  
     
    public void execute(JobExecutionContext context)  
        throws JobExecutionException {  
        _log.error("Hello Job执行时间: " + new Date());  
        iJobAndTriggerService.doSomething();

        //请求地址
        String url = "http://localhost:8080/eservices/rop/quartzApiDemo";
        RestTemplate restTemplate = new RestTemplate();
    	String json = restTemplate.getForEntity(url, String.class).getBody();
        String u= json.toString();
        _log.error(u);  
    }  
}  
