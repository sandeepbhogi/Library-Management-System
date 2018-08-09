package com.library.details;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.library.bean.Library;
import com.library.daoimpl.LibraryAdminDaoImpl;
import com.library.daoimpl.LibraryCustomerDaoImpl;
import com.library.main.LibraryClient;

public class LibraryDetails {
	static Scanner sc=new Scanner(System.in);
    static LibraryAdminDaoImpl libraryAdminDao=new  LibraryAdminDaoImpl();
    static LibraryCustomerDaoImpl libraryCustomerDao=new  LibraryCustomerDaoImpl();
    public static void adminMenu(){
    	
    	System.out.println("----------------------");
    	System.out.println("|     ADMIN MENU     |");
    	System.out.println("----------------------");
    	System.out.println("|    1.ADD BOOK     |");
        System.out.println("|    2.VIEW BOOK    |"); 
        System.out.println("|    3.VIEW ALL BOOKS|");
        System.out.println("|    4.UPDATE BOOK  |");
        System.out.println("|    5.DELETE BOOK  |");
        System.out.println("|    6.BACK          |");
        System.out.println("----------------------");
        System.out.println("Enter Your Choice?");
        int choice=sc.nextInt();
        switch(choice)
        {
        case 1:
        	  libraryAdminDao.addBook();
        	  adminMenu();
        	  break;
        case 2:
        	  System.out.println("Enter Book Id?");
        	  int Bookid=sc.nextInt();
        	  Library library=libraryAdminDao.viewBook(Bookid);
        	  System.out.println("BID"+"\t"+"BOOK_NAME"+"\t"+"PRICE"+"\t"+"QTY");
    		  System.out.println("---------------------------");
    		  System.out.println(library);
    		  adminMenu();
    		  break;
        case 3:
        	  List<Library>librarys=libraryAdminDao.viewAllBooks();
        	  System.out.println("BID"+"\t"+"BOOK_NAME"+"\t"+"PRICE"+"\t"+"QTY");
    		  System.out.println("---------------------------");
			for(Library l2:librarys ){
    		  System.out.println(l2);	  
    		  }
    		  adminMenu();
    		  break;
        case 4:
        	  System.out.println("Enter Update Book id?");
              libraryAdminDao.updateBook(sc.nextInt());
    		  adminMenu();	
    		  break;
        case 5:
        	 System.out.println("Enter Delete Book id?");
             libraryAdminDao.deleteBook(sc.nextInt());
   		     adminMenu();	
   		     break; 
        case 6:
        	 LibraryClient.main(null);
        	 break;
        default:
        	System.out.println("Select the choice range between 1-6 only");
        	break;
    			
    			
        }
    }
    
    
    public static void CustomerMenu(){

    	System.out.println("----------------------");
    	System.out.println("|    CUSTOMER MENU   |");
    	System.out.println("----------------------");
        System.out.println("|    1.VIEW BOOK    |"); 
        System.out.println("|    2.VIEW ALL BOOKS|");
        System.out.println("|    3.SELECT BOOK  |");
        System.out.println("|    4.BACK          |");
        System.out.println("----------------------");
        System.out.println("Enter Your Choice?");
        int choice=sc.nextInt();
        switch(choice)
        {
        case 1:
        	  System.out.println("Enter Book Id?");
        	  Library l3=libraryCustomerDao.viewBook(sc.nextInt());
  	          System.out.println("PID"+"\t"+"PIZZA_NAME"+"\t"+"PRICE"+"\t"+"QTY");
		      System.out.println("---------------------------");
		      System.out.println(l3);
		      CustomerMenu();
		      break;
		      
        case 2:
        
        	List<Library>librarys=libraryAdminDao.viewAllBooks();
      	  System.out.println("BID"+"\t"+"BOOK_NAME"+"\t"+"PRICE"+"\t"+"QTY");
  		  System.out.println("---------------------------");
			for(Library l2:librarys ){
  		  System.out.println(l2);	  
  		  }
  		  CustomerMenu();
  		  break; 
        case 3:
        	   libraryCustomerDao.selectBooks();
        	   CustomerMenu();
        	   break;
       case 4:
       	       LibraryClient.main(null);
    	       break;
      default:
    	       System.out.println("Select the choice range between 1-4 only");
    	       break;
        	
        }
}
}
