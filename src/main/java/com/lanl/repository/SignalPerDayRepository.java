package com.lanl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.lanl.model.SignalPerDay;


public interface SignalPerDayRepository extends BaseDao<SignalPerDay> {

	//@Query(value = "select * from stockquote where symbol = ?0 order by price_time desc limit 1", nativeQuery=true)
	@Query(value = "select * from signalperday where signal_day = ?1 order by symbol", nativeQuery=true)
	public List<SignalPerDay> findByDate(String day);

}
