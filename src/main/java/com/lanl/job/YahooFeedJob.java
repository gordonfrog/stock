package com.lanl.job;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lanl.model.WatchList;
import com.lanl.repository.WatchlistRepository;
import com.lanl.service.ScannerService;
import com.lanl.service.YahooFeedService;

@Component
@EnableScheduling
@PropertySource("classpath:scheduler.properties")
public class YahooFeedJob {

	private static Logger logger = LoggerFactory.getLogger(YahooFeedJob.class);
	
	@Autowired
	private YahooFeedService yahooFeedService;
	
	@Autowired
	private WatchlistRepository watchlistRepository;
	
	@Autowired
	private Environment env;

	@Autowired
	private ScannerService scannerService;
	
	@Scheduled(fixedDelayString = "${com.lanl.fixedrate}")
	public void runYahooFeedService() throws InterruptedException {
		Boolean isRun = Boolean.valueOf(env.getProperty("com.lanl.runYahooFeedService").toUpperCase());
		
		if (isRun)
			logger.info("*****YahooFeedJob is ON.******");
		else 
			logger.info("*****YahooFeedJob is OFF.******");
		if (isRun) {
			Integer sometime = Integer.valueOf(env.getProperty("com.lanl.sleep"));
			logger.info("sleep: "+sometime);
			String watchlistcode = env.getProperty("com.lanl.watchlistcode");
			logger.info("watchlistcode: "+watchlistcode);
			List<WatchList> watchlists = (List<WatchList>) watchlistRepository.findByWatchlistCode(watchlistcode);
			logger.info("watchlists size: "+watchlists.size());
			for (WatchList watchlist: watchlists) {
				logger.info("Start getting " + watchlist.getSymbol() + " data.");
				yahooFeedService.getData(watchlist.getSymbol());
				logger.info("Finish getting " + watchlist.getSymbol() + " data.");
				logger.info("Start scanning " + watchlist.getSymbol() + " data.");
				scannerService.scan(watchlist.getSymbol());
				logger.info("Finish scanning " + watchlist.getSymbol() + " data.");
				Thread.sleep(sometime);
			}
		}
	}
	
}
