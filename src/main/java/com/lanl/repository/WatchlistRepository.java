package com.lanl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.lanl.model.WatchList;


public interface WatchlistRepository extends BaseDao<WatchList> {
	
	//@Query(value = "select * from stockquote where symbol = ?0 order by price_time desc limit 1", nativeQuery=true)
	
	@Query(value = "select * from watchlist where watchlistcode='HK001' and symbol=?1", nativeQuery=true)
	public WatchList findBySymbol(String symbol);

	@Query(value = "select * from watchlist where watchlistcode='HK001' order by symbol", nativeQuery=true)
	public List<WatchList> findByWatchlistCode(String watchlistcode);

}
