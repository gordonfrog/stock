package com.lanl.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lanl.dto.Ohlc;
import com.lanl.model.Quote;
import com.lanl.repository.QuoteRepository;
import com.lanl.util.CommonUtil;

@RestController
@RequestMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
public class DataController {

	private static Logger logger = LoggerFactory.getLogger(DataController.class);
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Ohlc> symbolFeed(String symbol) {
		logger.info("Getting " + symbol + " prices");
		List<Quote> quotes = (List<Quote>) quoteRepository.findLastNBySymbol(symbol, 250);
		List<Ohlc> ohlcs = CommonUtil.convertQuotes(quotes);
		logger.info(ohlcs.toString());
		
		return ohlcs;
	}
	
}
