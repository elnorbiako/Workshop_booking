package pl.coderslab.entity;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

public class Main1 {
	
	
	public static void main(String[] args) {
		
		adminMenuUsers();		
		
	}

/**
 * application: Admin menu for managing users
 */
	public static void adminMenuUsers() {
		
		Scanner scan = new Scanner(System.in);
		
			
		
			System.out.println("User list: ");
			System.out.println(ArrayUtils.toString(User.loadAllUsers()));	
				
			System.out.println("Choose option: 'add' 'edit' 'delete' for users, or 'quit' to end :");
			String command = scan.nextLine();
			
			while(!command.equals("quit")) {
				
				
				try {
					
					if (command.equals("add")) {
					
						System.out.println("New user name:");
						String username = scan.nextLine();
						
						System.out.println("Email for " + username + " :");
						String email = scan.nextLine();
						
						System.out.println("Password for " + username + " :");
						String password = scan.nextLine();
												
						System.out.println("Set group id for " + username + " :");
						int userGroupId = scan.nextInt();
						scan.nextLine();
						
						User user= new User(username, email, password, userGroupId);
						
						User.add(user);			
					}
					
					else if (command.equals("edit")) {
						
						System.out.println("User Id to edit:");
						int userId = scan.nextInt();
						scan.nextLine();
						
						System.out.println("New username: ");
						String usernameEdit = scan.nextLine();
						
						System.out.println("New email for " + usernameEdit + " :");
						String email = scan.next();
						
						System.out.println("New password for " + usernameEdit + " :");
						String password = scan.next();
												
						System.out.println("New group id for " + usernameEdit + " :");
						int userGroupId = scan.nextInt();
						scan.nextLine();
						
						User editUser= User.read(userId);
						
						editUser.setName(usernameEdit);
						editUser.setEmail(email);
						editUser.setPassword(password);
						editUser.setUserGroupId(userGroupId);
						
						User.update(editUser);
					}
					
					else if (command.equals("delete")) {
						
						System.out.println("User Id to delete:");
						int userId = scan.nextInt();
						
						User.delete(userId);		
					}
					else{
						System.out.println("Please try again");
						}
											
				} catch (NumberFormatException e) {
					System.out.println("Not a number: " + e.getMessage());
				}
				
				
				
				System.out.println("User list: ");
				System.out.println(ArrayUtils.toString(User.loadAllUsers()));	
					
				System.out.println("Choose option: 'add' 'edit' 'delete' for users, or 'quit' to end :");
				command = scan.nextLine();
			}
								
			scan.close();
		}
							    
		
}


	

/*
import java.util.Arrays;

public class Main1{
	
	public static void main(String[] args) {
		
		
		Reservation reserv = new Reservation("2018-04-18", "2018-04-28", "test desc 2", 3, 4, 2);
		
		Reservation.add(reserv);
		
	}
}


*/