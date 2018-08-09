package com.library.dao;

import java.util.List;

import com.library.bean.Library;

public interface LibraryAdminDao {
	public void addBook();

	public Library viewBook(int Bookid);

	public List<Library> viewAllBooks();

	public void updateBook(int Bookid);

	public void deleteBook(int Bookid);
}
