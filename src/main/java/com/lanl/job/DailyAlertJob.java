package com.lanl.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lanl.service.DailyAlertService;

@Component
@EnableScheduling
@PropertySource("classpath:scheduler.properties")
public class DailyAlertJob {

	private static Logger logger = LoggerFactory.getLogger(DailyAlertJob.class);
	
	@Autowired
	private Environment env;

	@Autowired
	private DailyAlertService dailyAlertService;
	
	@Scheduled(cron = "${com.lanl.alert.send}")
	public void runDailyAlertService() throws InterruptedException {
		Boolean isRun = Boolean.valueOf(env.getProperty("com.lanl.runDailyAlertService").toUpperCase());

		if (isRun) {
			logger.info("Start sending alert.");
			dailyAlertService.generateTradingSignalAlert();
			logger.info("Finished sending alert.");
		}
	}

}
