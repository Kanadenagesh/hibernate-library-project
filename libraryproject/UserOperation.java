package libraryproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;

public class UserOperation {
	
	public static void adduser(Session session) {
		Scanner sc = new Scanner(System.in);
		User u1 = new User();
		System.out.println("Enter Username");
		String username = sc.nextLine();
		System.out.println("Enter password");
		String password =sc.nextLine();
		u1.setUsername(username);
		u1.setPassword(password);
		session.beginTransaction();

	
		session.save(u1);
		session.getTransaction().commit();
		System.out.println("Inserted User:"+u1.getUsername());
	}
	
	@SuppressWarnings("unchecked")
	public static void viewusers(Session session) {
		
		Query query = session.createQuery("from User");
		List<User>userlist= new ArrayList<User>(); 
		userlist = query.getResultList();
		for(User uobj:userlist) {
			System.out.println(uobj.toString());;
		}
	}
	
	public static void deleteuser(Session session) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Id to Delete");
		int user_id = sc.nextInt();
		User u2 = new User();
		u2.setId(user_id);
		

		session.beginTransaction();
		User u3 = session.get(User.class, user_id);
		session.remove(u3);;
		session.getTransaction().commit();
		System.out.println("Deleted user with Id:"+user_id);
		
	}

}
