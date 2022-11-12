package libraryproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;

public class BookOperations {

	public static void addbook(Session session) {
		Scanner sc = new Scanner(System.in);

		Book b1 = new Book();
		System.out.println("Enter Book Name");
		String bookname = sc.nextLine();
		b1.setBookname(bookname);
		session.beginTransaction();

		session.save(b1);

		session.getTransaction().commit();
		System.out.println("Inserted Book:" + b1.getBookname());

	}

	@SuppressWarnings("unchecked")
	public static void viewbooks(Session session) {

		Query query = session.createQuery("from Book");
		List<Book> booklist = new ArrayList<Book>();
		booklist = query.getResultList();
		for (Book bobj : booklist) {

			System.out.println(bobj.toString());
			;
		}

	}

	public static void deletebook(Session session) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Book Id to Delete");
		int book_id = sc.nextInt();
		
		Book b2 = new Book();
		b2.setId(book_id);
		session.beginTransaction();
		Book delbook = session.get(Book.class, book_id);
		session.delete(delbook);
		session.getTransaction().commit();
		System.out.println("Deleted Book With Id:"+book_id);
		

	}
}
