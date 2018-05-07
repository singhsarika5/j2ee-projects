package com.myprojects.dao;

import java.sql.PreparedStatement;
import com.myprojects.beans.*;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;

public class BookDao {
	
	public static int save(Book bean) {
		int status = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into e_book values(?,?,?,?,?,?)");
			ps.setString(1,bean.getColNo());
			ps.setString(2,bean.getName());
			ps.setString(3,bean.getAuthor());
			ps.setString(4,bean.getPublisher());
			ps.setInt(5,bean.getQuantity());
			ps.setInt(6, bean.getIssued());
			status = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	public static List<Book> view() {
		List<Book> list = new ArrayList<Book>();	
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select *from e_book");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Book b1 = new Book();
				b1.setColNo(rs.getString(1));
				b1.setName(rs.getString(2));
				b1.setAuthor(rs.getString(3));
				b1.setPublisher(rs.getString(4));
				b1.setQuantity(rs.getInt(5));
				b1.setIssued(rs.getInt(6));
				list.add(b1);
			}		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static int getIssued(String colNo) {
		int issued = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select *from e_book where colno = ?");
			ps.setString(1, colNo);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				issued = rs.getInt(6);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return issued;
	}
	
	public static int delete(String colNo) {
		int status = 0;
		try {
			
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from e_book where colno = ?");
			ps.setString(1, colNo);
			status = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return status;
	}
	
	public static boolean checkIssue(String colNo) {
		boolean status = false;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select *from e_book where colno = ? and quantity > issued");
			ps.setString(1, colNo);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				status = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static int issueBook(IssuedBook issuedBook) {
		String colNo = issuedBook.getColNo();
		boolean checkStatus = checkIssue(colNo);
		if(checkStatus) {
			int status = 0;
			try {
				Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("insert into e_issuedbook values(?,?,?,?,?,?)");
				ps.setString(1, issuedBook.getColNo());
				ps.setString(2, issuedBook.getStudentId());
				ps.setString(3, issuedBook.getStudentName());
				ps.setLong(4, issuedBook.getStudentMobile());
				java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
				ps.setDate(5, currentDate);
				ps.setString(6, "no");
				status = ps.executeUpdate();
				if(status > 0) {
					PreparedStatement ps1 = con.prepareStatement("update e_book set issued = ? where colno = ?");
					ps1.setInt(1, getIssued(colNo) + 1);
					ps1.setString(2, colNo);
					status = ps.executeUpdate();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return status;
		}
		else {
			return 0;
		}
	}
	
	
	public static int returnBook(String colNo, String studentId) {
		
		int status = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("update e_issuebook set returnstatus='yes' where colno = ?  and studentid = ?");
			ps.setString(1, colNo);
			ps.setString(2, studentId);
			status = ps.executeUpdate();
			if(status > 0) {
				PreparedStatement ps1 = con.prepareStatement("update e_book set issued = ? where colno =?");
				ps1.setInt(1, getIssued(colNo) - 1);
				ps1.setString(2, colNo);
				status = ps1.executeUpdate();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static List<IssuedBook> viewIssuedBook() {
		List<IssuedBook> list = new ArrayList<IssuedBook>();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from e_issuedbook order by issueddate desc");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				IssuedBook issueBook = new IssuedBook();
				issueBook.setColNo(rs.getString(1));
				issueBook.setStudentId(rs.getString(2));
				issueBook.setStudentName(rs.getString(3));
				issueBook.setStudentMobile(rs.getLong(4));
				issueBook.setIssuedDate(rs.getDate(5));
				issueBook.setReturnStatus(rs.getString(6));
				list.add(issueBook);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}






























