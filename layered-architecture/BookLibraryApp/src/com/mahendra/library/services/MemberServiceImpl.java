package com.mahendra.library.services;

import java.util.ArrayList;
import java.util.List;

import com.mahendra.library.dao.MemberDAO;
import com.mahendra.library.models.Member;

public class MemberServiceImpl implements MemberService {

	private MemberDAO dao;

	public MemberServiceImpl(MemberDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public Member findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Member> findByName(String name) {
		List<Member> result = new ArrayList<>();
		result.addAll(dao.findByFirstName(name));
		result.addAll(dao.findByLastName(name));
		return result;
	}

	@Override
	public List<Member> findAvailable() {
		return dao.findByStatus('A');
	}

	@Override
	public Member create(Member m) {
		int newId = dao.nextId();
		m.setId(newId);
		dao.save(m);
		return m;
	}

	@Override
	public void update(Member m) {
		dao.update(m);
	}

}
