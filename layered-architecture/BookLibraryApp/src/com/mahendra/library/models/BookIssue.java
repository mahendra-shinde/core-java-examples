package com.mahendra.library.models;

import java.io.Serializable;
import java.util.Date;

public class BookIssue implements Serializable{
	private Integer id;
	private Integer bookId;
	private Integer memberId;
	private Date dateOfIssue;
	private Date estimatedReturnDate;
	// actualReturnDate = NULL  Book not returned yet
	// actualReturnDate != NULL, Book is returned
	private Date actualReturnDate;
	//STATUS = 'P' Book not returned
	//STATUS = 'R' Book has been returned
	private char status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Date getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public Date getEstimatedReturnDate() {
		return estimatedReturnDate;
	}
	public void setEstimatedReturnDate(Date estimatedReturnDate) {
		this.estimatedReturnDate = estimatedReturnDate;
	}
	public Date getActualReturnDate() {
		return actualReturnDate;
	}
	public void setActualReturnDate(Date actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public BookIssue(Integer id, Integer bookId, Integer memberId, Date dateOfIssue, Date estimatedReturnDate,
			Date actualReturnDate, char status) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.memberId = memberId;
		this.dateOfIssue = dateOfIssue;
		this.estimatedReturnDate = estimatedReturnDate;
		this.actualReturnDate = actualReturnDate;
		this.status = status;
	}
	public BookIssue() {
		super();
	}
	
}
