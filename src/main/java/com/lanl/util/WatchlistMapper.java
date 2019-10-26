package com.lanl.util;

import org.springframework.stereotype.Component;

import com.lanl.dto.WatchlistForm;
import com.lanl.model.WatchList;

@Component
public class WatchlistMapper {

	public WatchList map(WatchlistForm model) {
		WatchList domain = new WatchList();
		
		domain.setWatchlistcode(model.getWatchlistcode());
		domain.setSymbol(model.getSymbol());
		domain.setActive(model.getActive());
		
		return domain;
	}
	
	public WatchlistForm map(WatchList domain) {
		WatchlistForm model = new WatchlistForm();
		
		model.setWatchlistcode(domain.getWatchlistcode());
		model.setSymbol(domain.getSymbol());
		model.setActive(domain.getActive());
		
		return model;
	}
	
}
