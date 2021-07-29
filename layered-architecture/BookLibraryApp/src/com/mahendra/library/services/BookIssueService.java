package com.mahendra.library.services;

import java.util.Date;
import java.util.List;

import com.mahendra.library.models.*;

public interface BookIssueService {
	BookIssue findById(Integer id);
	List<BookIssue> findByBookId(Integer id);
	List<BookIssue> findByMemberId(Integer id);
	BookIssue create(BookIssue b);
	void update(BookIssue b);
	List<BookIssue> findOverdue();
	List<BookIssue> findReturned();
	List<BookIssue> findByReturnDate(Date date);
	List<BookIssue> findIssuedOn(Date date);

}
