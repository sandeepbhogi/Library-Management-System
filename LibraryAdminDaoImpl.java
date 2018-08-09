package com.library.daoimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.library.bean.Library;
import com.library.dao.LibraryAdminDao;

public class LibraryAdminDaoImpl implements LibraryAdminDao {
	Scanner sc=new Scanner(System.in);
	List<Library>librarys=new ArrayList<Library>();
	List<Library>tempList=new ArrayList<Library>();
	File original=new File("library.txt");
	File tempFile=new File("temp.txt");
	FileInputStream fis=null;
	FileOutputStream fos=null;
	ObjectInputStream ois=null;
	ObjectOutputStream oos=null;
	Library library=null;
	@Override
	public void addBook() {
		// TODO Auto-generated method stub
		
		try {
			int i=1;
			while(i==1)
			{
				System.out.println("Enter Book Id?");
				String id = sc.next();
				while(!Pattern.matches("\\d{2}", id))
				{
					System.err.println("Please Enter Book id Two digit number Ex:12");
					id = sc.next();
				}
				System.out.println(id);
				//library.setBookid(Integer.parseInt(id));

				System.out.println("Enter Book Name?");
				//library.setBookname(sc.next());
				String name=sc.next();
				System.out.println(" Enter Book price?");
				//library.setPrice(sc.nextDouble());
				double price=sc.nextDouble();
				System.out.println("  Enter Book Qty?");
				String Qty= sc.next();
				while(!Pattern.matches("\\d{2}", Qty))
				{
					System.err.println("Please Enter Book Qty Two digit number Ex:12");
					Qty = sc.next();
				}
				//library.setQty(Integer.parseInt(Qty));
				library=new Library(Integer.parseInt(id),name,price,Integer.parseInt(Qty));			
				librarys.add(library);
				System.out.println("Do You Want To Add More Books press 1 else Any Number ");
				i=sc.nextInt();
			}
			fos=new FileOutputStream(original);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(librarys);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("-------BOOKS ADDED SUCCESSFULLY-------");

	}

	@Override
	public Library viewBook(int Bookid) {
		// TODO Auto-generated method stub
		
		
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
			    	library=library;
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
	public void updateBook(int Bookid) {
		// TODO Auto-generated method stub
		try {
			librarys=new ArrayList<Library>();
			tempList=new ArrayList<Library>();
			fis=new FileInputStream(original);
			ois=new ObjectInputStream(fis);
			librarys=(List<Library>)ois.readObject();
			for(Library l:librarys)
			{ 
				if(l.getBookid()==Bookid)
				{
					System.out.println("Select Field Do You Want to update 1.Name 2.price 3.qty");
			        int choice=sc.nextInt();
			        switch(choice)
			        {
			        case 1:  System.out.println("Enter Updated Book Name?");
			                 l.setBookname(sc.next());
			                 break;
			        case 2:  System.out.println(" Enter Updated Book Price?");
			                 l.setPrice(sc.nextDouble());
			                 break;
			        case 3:  System.out.println("Enter Updated Book Qty?");
			                 l.setQty(sc.nextInt()); 
			                 break;
			        default: System.out.println("Please Select Choice Range Between 1-3 only");
			                 break;
			        }
				    
			        tempList.add(l);
				}else{
					tempList.add(l);
				}
			}
			fos=new FileOutputStream(tempFile);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(tempList);
			original.delete();
			tempFile.renameTo(original);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            System.out.println("BOOK DETAILS UPDATED SUCCESSFULLY.... ");
	}

	@Override
	public void deleteBook(int Bookid) {
		// TODO Auto-generated method stub
		try {
			librarys=new ArrayList<Library>();
			tempList=new ArrayList<Library>();
			fis=new FileInputStream(original);
			ois=new ObjectInputStream(fis);
			librarys=(List<Library>)ois.readObject();
			for(Library l:librarys)
			{ 
				if(l.getBookid()==Bookid)
				{
					
				}else{
					tempList.add(l);
				}
				fos=new FileOutputStream(tempFile);
				oos=new ObjectOutputStream(fos);
				oos.writeObject(tempList);
				original.delete();
				tempFile.renameTo(original);
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		System.out.println("BOOK DETAILS DELETED SUCCESSFULLY....");
	}

}
