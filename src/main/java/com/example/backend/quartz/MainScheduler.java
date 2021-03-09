package com.example.backend.quartz;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainScheduler implements CommandLineRunner {

    private static Scheduler sched;

    public MainScheduler(Scheduler scheduler) {
        sched = scheduler;
    }

    @Override
    public void run(String... args) throws Exception {

        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(jobDemo.class).withIdentity("jobDemo", "groupDemo").build();
        //创建触发器 每3秒钟执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("jobDemo", "groupDemo")
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


}
