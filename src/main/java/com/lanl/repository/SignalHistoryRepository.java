package com.lanl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.lanl.model.SignalHistory;

public interface SignalHistoryRepository extends BaseDao<SignalHistory> {

	//@Query(value = "select * from stockquote where symbol = ?0 order by price_time desc limit 1", nativeQuery=true)
	@Query(value = "select * from signalhistory where symbol = ?1 order by signal_time desc", nativeQuery=true)
	public List<SignalHistory> findBySymbol(String symbol);

}
