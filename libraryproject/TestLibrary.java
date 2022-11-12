package libraryproject;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestLibrary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(Book.class);
		SessionFactory sessionfactory = config.buildSessionFactory();
		Session session = sessionfactory.openSession();
		
		int choice;
		
		
		do {
			System.out.println("1:Add User\n2:View Users\n3:Delete User\n4:Add Book\n5:View Books\n6:Delete Book\n0:Exit");
			System.out.println("Enter Choice");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				UserOperation.adduser(session);
				break;
				
			case 2:
				UserOperation.viewusers(session);
				break;
				
			case 3:
				UserOperation.deleteuser(session);
				break;
				
			case 4:
				BookOperations.addbook(session);
				break;
				
			case 5:
				BookOperations.viewbooks(session);
				break;
				
			case 6:
				BookOperations.deletebook(session);
				break;
			}
			
		} while (choice!=0);
		
		
		
		
		sessionfactory.close();
		session.close();
		sc.close();

	}

}
