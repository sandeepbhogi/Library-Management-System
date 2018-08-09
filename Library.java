package com.library.bean;

import java.io.Serializable;

public class Library implements Serializable{
	private int Bookid;
	private String Bookname;
	private double price;
	private int qty;
	public Library(int Bookid, String Bookname, double price, int qty) {
		super();
		this.Bookid = Bookid;
		this.Bookname = Bookname;
		this.price = price;
		this.qty = qty;
	}
	
public Library(int bookid, int qty) {
		super();
		Bookid = bookid;
		this.qty = qty;
	}

public Library() {
		
	}
	
	public int getBookid() {
		return Bookid;
	}
	public void setBookid(int libraryid) {
		this.Bookid = Bookid;
	}
	public String getBookname() {
		return Bookname;
	}
	public void setBookname(String libraryname) {
		this.Bookname = libraryname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Bookid=" + Bookid + ", Bookname="
				+ Bookname + ", price=" + price + ", qty=" + qty ;
	}
}
