package com.mahendra.library.dao;

import java.util.Date;
import java.util.List;

import com.mahendra.library.models.BookIssue;

public interface BookIssueDAO {

	BookIssue findById(Integer id);
	List<BookIssue> findByIssueDate(Date issueDate);
	List<BookIssue> findByEstimatedReturnDate(Date estimatedReturnDate);
	List<BookIssue> findByBookId(Integer bookId);
	List<BookIssue> findByMemberId(Integer memberId);
	void update(BookIssue BookIssue);
	void save(BookIssue BookIssue);
}
