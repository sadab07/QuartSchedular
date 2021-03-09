package com.example.quartztask.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.quartz.JobDataMap;
import org.quartz.Scheduler;

import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;

import org.quartz.impl.JobDetailImpl;

import org.quartz.impl.StdSchedulerFactory;

import org.quartz.impl.triggers.SimpleTriggerImpl;

public class QuartzModel {

	public static void run(String name) throws SchedulerException {

		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("name", name);

		// Creating scheduler factory and scheduler

		SchedulerFactory factory = new StdSchedulerFactory();

		Scheduler scheduler = factory.getScheduler();

		JobDataMap jobMap = new JobDataMap();
		jobMap.putAll(map);

		// Creating Job and link to our Job class

		JobDetailImpl jobDetail = new JobDetailImpl();

		jobDetail.setName("First Job");

		jobDetail.setJobClass(Demo.class);
		jobDetail.setJobDataMap(jobMap);

		// Creating schedule time with trigger

		SimpleTriggerImpl simpleTrigger = new SimpleTriggerImpl();

		simpleTrigger.setStartTime(new Date(System.currentTimeMillis() + 1000));

		// simpleTrigger.setRepeatCount(SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW);

		simpleTrigger.setRepeatInterval(1000);

		simpleTrigger.setName("FirstTrigger");

		// simpleTrigger.setStartTime(new Date(2021, 03, 06, 05, 14) );

		// Start scheduler

		scheduler.start();

		scheduler.scheduleJob(jobDetail, simpleTrigger);

	}
}