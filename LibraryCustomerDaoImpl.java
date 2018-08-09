package com.library.daoimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.library.bean.Library;
import com.library.dao.LibraryCustomerDao;

public class LibraryCustomerDaoImpl implements LibraryCustomerDao {
	Scanner sc=new Scanner(System.in);
	List<Library> library = new ArrayList<Library>();
	List<Library> librarys = null;
	List<Library>tempList=null;
	File original=new File("library.txt");
	File tempFile=new File("temp.txt");
	FileInputStream fis=null;
	FileOutputStream fos=null;
	ObjectInputStream ois=null;
	ObjectOutputStream oos=null;
	Library li=null;
	
	
	@Override
	public Library viewBook(int Bookid) {
		// TODO Auto-generated method stub
Library library=null;
		
		try {
			librarys=new ArrayList<Library>();
			fis=new FileInputStream(original);
			ois=new ObjectInputStream(fis);
			librarys=(List<Library>)ois.readObject();
			Iterator<Library> it=librarys.iterator();
			while(it.hasNext())
			{
			     library=it.next();
			     
			     if(library.getBookid()==Bookid){
			    	 break;
			     }

			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return library;
	}


	@Override
	public List<Library> viewAllBooks() {
		// TODO Auto-generated method stub
		try {
			librarys=new ArrayList<Library>();
			fis=new FileInputStream(original);
			ois=new ObjectInputStream(fis);
			librarys=(List<Library>)ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return librarys;
	}

	@Override
	public void selectBooks() {
		// TODO Auto-generated method stub
	
	try {
		librarys=new ArrayList<Library>();
		fis=new FileInputStream("library.txt");
		ois=new ObjectInputStream(fis);
		librarys=(List<Library>)ois.readObject();
		System.out.println("BOOKID"+"\t"+"BOOK_NAME"+"\t"+"PRICE"+"\t"+"BOOK_QUANTITY");
		System.out.println("-------------------------------------------------------------");
		tempList=new ArrayList<Library>();
		
		for(Library l2 :librarys)
		{
			System.out.println(l2.getBookid()+"\t"+l2.getBookname()+"\t"+l2.getPrice()+"\t"+l2.getQty());
		}
		
		System.out.println("Enter selected Book Id");
		int bid=sc.nextInt();
		System.out.println("Enter selected Book Qty");
		int qty=sc.nextInt();
		Library li=new Library(bid,qty);
		
		for(Library l1:librarys)
		{
			if(l1.getBookid()==li.getBookid())
			{
				System.out.println("--------------------------");
				System.out.println("----------LIBRARY--------");
				System.out.println("----------------------------");
				System.out.println("|BOOK Id     |    " + l1.getBookid()+ "|");
				System.out.println("|BOOK Name     |    " + l1.getBookname()+ "|");
				System.out.println("|BOOK Qty    |    "+ (l1.getQty() - li.getQty()) + "|");
				System.out.println("----------------------------");
				System.out.println("|Total        |    "+ (l1.getPrice() * li.getQty()) + "|");
				System.out.println("----------------------------");

				l1.setQty(l1.getQty()-li.getQty());
				tempList.add(l1);
			}
			else{
				tempList.add(l1);
			}
		}
		fos=new FileOutputStream(original);
		oos=new ObjectOutputStream(fos);
		oos.writeObject(tempList);
		original.delete();
		tempFile.renameTo(original);
	} catch (  ClassNotFoundException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
