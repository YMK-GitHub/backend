package com.example.backend.quartz;

import org.quartz.Scheduler;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class SchedulerConfig {

	@Autowired
    private JobFactory jobFactory;

	public SchedulerConfig(JobFactory jobFactory){
        this.jobFactory = jobFactory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setQuartzProperties(quartzProperties());
        //用于quartz集群，QuartzScheduler启动时更新已存在的job
//        factory.setOverwriteExistingJobs(true);
        // 延时启动，应用启动1秒后
        factory.setStartupDelay(5);
        factory.setJobFactory(jobFactory);
        return factory;
    }

    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        return propertiesFactoryBean.getObject();
    }

    @Bean(name = "scheduler")
    public Scheduler scheduler() throws IOException {

        return schedulerFactoryBean().getScheduler();
    }
}
