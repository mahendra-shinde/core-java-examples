package com.mahendra.library.services;

import java.util.Date;
import java.util.List;

import com.mahendra.library.dao.BookIssueDAO;
import com.mahendra.library.models.BookIssue;

public class BookIssueServiceImpl implements BookIssueService {

	private BookIssueDAO dao;
	
	public BookIssueServiceImpl(BookIssueDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public BookIssue findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<BookIssue> findByBookId(Integer id) {
		return dao.findByBookId(id);
	}

	@Override
	public List<BookIssue> findByMemberId(Integer id) {
		return dao.findByMemberId(id);
	}

	@Override
	public BookIssue create(BookIssue b) {
		int newId = dao.nextId();
		b.setBookId(newId);
		dao.save(b);
		return b;
	}

	@Override
	public void update(BookIssue b) {
		dao.update(b);
	}

	@Override
	public List<BookIssue> findOverdue() {
		// TODO Auto-generated method stub
		return dao.findByEstimatedReturnDate(new Date());
	}

	@Override
	public List<BookIssue> findReturned() {
		// TODO Auto-generated method stub
		return dao.findByStatus('R');
	}

	@Override
	public List<BookIssue> findByReturnDate(Date date) {
		return dao.findByEstimatedReturnDate(date);
	}

	@Override
	public List<BookIssue> findIssuedOn(Date date) {
		// TODO Auto-generated method stub
		return dao.findByIssueDate(date);
	}

}
