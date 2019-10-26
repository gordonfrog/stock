package com.lanl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.lanl.model.Member;
import com.lanl.model.Quote;

public interface QuoteRepository extends BaseDao<Quote> {
	
	//@Query("SELECT t.title FROM Todo t where t.id = :id") 
	//@Query(value = "SELECT * FROM todos t where t.title = ?0 AND t.description = ?1", nativeQuery=true)
	//@Query(value = "SELECT m FROM member m where m.username = ?0", nativeQuery=true)
	//@Query("select * from member where active = 'Y'")
	

	@Query(value = "select * from stockquote where symbol = ?1 order by price_time desc limit 1", nativeQuery=true)
	public Quote findLastBySymbol(String symbol);

	@Query(value = "select * from stockquote where symbol = ?1 order by price_time desc limit ?2", nativeQuery=true)
	public List<Quote> findLastNBySymbol(String symbol, Integer count);

}
