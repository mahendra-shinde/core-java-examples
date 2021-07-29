package com.mahendra.library.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.mahendra.library.exceptions.ApplicationException;
import com.mahendra.library.models.Book;
import com.mahendra.library.models.Member;

public class MemberDAOImpl implements MemberDAO {

	private DataStore store = DataStore.getInstance();
	
	
	@Override
	public Member findById(Integer id) {
		return store.getMembers().get(id);
	}

	@Override
	public List<Member> findByFirstName(String firstName) {
		List<Member> temp = new ArrayList<>();
		Collection<Member> members = store.getMembers().values();
		for(Member m : members) {
			if(m.getFirstName().equalsIgnoreCase(firstName)) {
				System.out.println("Member found : "+m.getFirstName());
				temp.add(m);
			}
		}
		return temp;
	}

	@Override
	public List<Member> findByLastName(String lastName) {
		List<Member> temp = new ArrayList<>();
		Collection<Member> members = store.getMembers().values();
		for(Member m : members) {
			if(m.getLastName().equalsIgnoreCase(lastName)) {
				System.out.println("Member found : "+m.getLastName());
				temp.add(m);
			}
		}
		return temp;
	}

	@Override
	public void update(Member member) {
		if(findById(member.getId())==null)
			throw new ApplicationException("Member not found!");
		store.getMembers().put(member.getId(), member);

	}

	@Override
	public void save(Member member) {
		if(findById(member.getId())!=null)
			throw new ApplicationException("Member already exists!");
		store.getMembers().put(member.getId(),member);
	}

	@Override
	public List<Member> findByStatus(char status) {
		List<Member> temp = new ArrayList<>();
		Collection<Member> members = store.getMembers().values();
		for(Member m : members) {
			if(m.getStatus()==status) {
				System.out.println("Member found : "+m.getLastName());
				temp.add(m);
			}
		}
		return temp;
	}

	@Override
	public int nextId() {
		Set<Integer> keys = store.getMembers().keySet();
		int highest = 0;
		for(int key : keys) {
			if(key > highest) {
				highest = key;
			}
		}
		return highest+1;
	}

	
}
