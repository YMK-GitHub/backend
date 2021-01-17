package com.example.backend.task;

import com.example.backend.controller.controllerDemo;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class MainScheduler  implements CommandLineRunner {

    private static Scheduler sched;
    //创建调度器
    public   Scheduler getScheduler() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        return schedulerFactory.getScheduler();
    }


    public   void schedulerJob() throws SchedulerException{
        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(jobDemo.class).withIdentity("job1", "group1").build();
        //创建触发器 每3秒钟执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group3")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever())
                .build();
        Scheduler scheduler = getScheduler();
        //将任务及其触发器放入调度器
        scheduler.scheduleJob(jobDetail, trigger);
        //调度器开始调度任务
        scheduler.start();

    }


    @Override
    public void run(String... args) throws Exception {

        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(jobDemo.class).withIdentity("job1", "group1").build();
        //创建触发器 每3秒钟执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group3")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever())
                .build();

        //将任务及其触发器放入调度器
        sched.scheduleJob(jobDetail, trigger);
        //调度器开始调度任务
        sched.start();

    }
    public static Scheduler getSched() {
        return sched;
    }
    public MainScheduler(Scheduler scheduler){
        sched = scheduler;
    }






}
