package com.library.dao;

import java.util.List;

import com.library.bean.Library;

public interface LibraryCustomerDao {
	public Library viewBook(int Bookid);
	public List<Library> viewAllBooks();
	public void selectBooks();
}
