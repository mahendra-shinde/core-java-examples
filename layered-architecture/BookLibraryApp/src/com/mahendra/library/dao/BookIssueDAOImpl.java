package com.mahendra.library.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.mahendra.library.exceptions.ApplicationException;
import com.mahendra.library.models.BookIssue;

public class BookIssueDAOImpl implements BookIssueDAO {

	private DataStore store = DataStore.getInstance();
	
	@Override
	public BookIssue findById(Integer id) {
		return store.getIssues().get(id);
	}

	@Override
	public List<BookIssue> findByIssueDate(Date issueDate) {
		List<BookIssue> issues = new ArrayList<BookIssue>();
		Collection<BookIssue> temp = store.getIssues().values();
		for(BookIssue issue : temp) {
			if(issue.getDateOfIssue().equals(issueDate)) {
				issues.add(issue);
			}
		}
		return issues;
	}

	@Override
	public List<BookIssue> findByEstimatedReturnDate(Date estimatedReturnDate) {
		List<BookIssue> issues = new ArrayList<BookIssue>();
		Collection<BookIssue> temp = store.getIssues().values();
		for(BookIssue issue : temp) {
			if(issue.getEstimatedReturnDate().equals(estimatedReturnDate) ||
				issue.getEstimatedReturnDate().after(estimatedReturnDate)) {
				issues.add(issue);
			}
		}
		return issues;			
	}

	@Override
	public List<BookIssue> findByBookId(Integer bookId) {
		List<BookIssue> issues = new ArrayList<BookIssue>();
		Collection<BookIssue> temp = store.getIssues().values();
		for(BookIssue issue : temp) {
			if(issue.getBookId()==bookId){
				issues.add(issue);
			}
		}
		return issues;
	}

	@Override
	public List<BookIssue> findByMemberId(Integer memberId) {
		List<BookIssue> issues = new ArrayList<BookIssue>();
		Collection<BookIssue> temp = store.getIssues().values();
		for(BookIssue issue : temp) {
			if(issue.getMemberId()==memberId){
				issues.add(issue);
			}
		}
		return issues;
	}

	@Override
	public void update(BookIssue bookIssue) {
		if(findById(bookIssue.getId())==null)
			throw new ApplicationException("Issue not found!");
		store.getIssues().put(bookIssue.getId(),bookIssue);
	}

	@Override
	public void save(BookIssue bookIssue) {
		if(findById(bookIssue.getId())!=null)
			throw new ApplicationException("Issue already exists!");
		store.getIssues().put(bookIssue.getId(),bookIssue);
	}

	@Override
	public int nextId() {
		Set<Integer> keys = store.getIssues().keySet();
		int highest = 0;
		for(int key : keys) {
			if(key > highest) {
				highest = key;
			}
		}
		return highest+1;
	}

	@Override
	public List<BookIssue> findByStatus(char status) {
		List<BookIssue> issues = new ArrayList<BookIssue>();
		Collection<BookIssue> temp = store.getIssues().values();
		for(BookIssue issue : temp) {
			if(issue.getStatus()==status) {
				issues.add(issue);
			}
		}
		return issues;
	}
}
