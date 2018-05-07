package com.myprojects.beans;

import java.sql.Date;

public class IssuedBook {
	private String colNo, studentId, studentName;
	private long studentMobile;
	private Date issueDate;
	private String returnStatus;

	public IssuedBook() {
	}

	public IssuedBook(String colNo, String studentId, String studentName, long studentMobile) {
		this.colNo = colNo;
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentMobile = studentMobile;
	}

	public Date getIssuedDate() {
		return this.issueDate;
	}
	
	public String getColNo() {
		return this.colNo;
	}

	public String getReturnStatus() {
		return this.returnStatus;
	}

	public String getStudentId() {
		return this.studentId;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public long getStudentMobile() {
		return this.studentMobile;
	}

	public void  setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

	public void setIssuedDate(Date date) {
		this.issueDate = date;
	}
	
	public void setColNo(String colNo) {
		this.colNo = colNo;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void setStudentMobile(long studentMobile) {
		this.studentMobile = studentMobile;
	}
}
