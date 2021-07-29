package com.mahendra.library.dao;

import java.util.List;

import com.mahendra.library.models.Member;

public interface MemberDAO {

	Member findById(Integer id);
	List<Member> findByFirstName(String firstName);
	List<Member> findByLastName(String lastName);
	List<Member> findByStatus(char status);
	void update(Member Member);
	void save(Member Member);
	
	int nextId();
}
