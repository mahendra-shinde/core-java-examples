package com.mahendra.library.services;

import java.util.List;

import com.mahendra.library.models.Member;

public interface MemberService {

	Member findById(Integer id);
	List<Member> findByName(String name);
	List<Member> findAvailable();
	Member create(Member m);
	void update(Member m);
	
}
