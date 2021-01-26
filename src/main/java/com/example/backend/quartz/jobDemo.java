package com.example.backend.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class jobDemo implements Job {


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //打印现象
        //        System.out.println("quartzJob执行了");
    }
}
