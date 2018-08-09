package com.library.main;

import java.util.Scanner;

import com.library.details.LibraryDetails;

public class LibraryClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("--------------------------");
			System.out.println("|      LIBRARYSYSTEM     |");
			System.out.println("--------------------------");
			System.out.println("|       1.ADMIN          |");
			System.out.println("        2.CUSTOMER       |");
            System.out.println("|       3.EXIT           |");
            System.out.println("--------------------------");
            System.out.println("Enter Your Choice");
            int choice=sc.nextInt();
            switch(choice)
            {
            case 1:
                  System.out.println("Enter Admin Password");
                  String adminPassword=sc.next();
                  if(adminPassword.equalsIgnoreCase("admin")){
            	  LibraryDetails.adminMenu();
                  }else{
            	  System.out.println("Enter Correct Password");
                  }
                  break;
            case 2:
            	   System.out.println("Enter Customer Password");
                   String CustomerPassword=sc.next();
                   if(CustomerPassword.equalsIgnoreCase("customer")){
                   	LibraryDetails.CustomerMenu();
                   	
                   }else{
                   	 System.out.println("Enter Correct Password");
                   } 
            break;
            case 3:
            	  System.exit(0);
            	  break;
            default:
            	   System.out.println("please select choice range 1-3 only ");
            	   break; 
            }
		}

	}
	}


