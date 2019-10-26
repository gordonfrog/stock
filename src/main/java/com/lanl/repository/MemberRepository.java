package com.lanl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.lanl.model.Member;


public interface MemberRepository extends BaseDao<Member> {

	//@Query("SELECT t.title FROM Todo t where t.id = :id") 
	//@Query(value = "SELECT * FROM todos t where t.title = ?0 AND t.description = ?1", nativeQuery=true)
	//@Query("select m from member m where m.username = :username")
	@Query(value = "SELECT * FROM member where username = ?1", nativeQuery=true)
	public Member findByUsername(String username);

	//@Query("select * from member where active = 'Y'")
	@Query(value = "SELECT * FROM member where active = 'Y'", nativeQuery=true)
	public List<Member> findByActive();
}
