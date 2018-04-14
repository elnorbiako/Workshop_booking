package pl.coderslab.entity;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

public class Main2{
	
	
	public static void main(String[] args) {
		
		adminUserBySurname();
		
	}
	
	/**
	 * method asks for user surname, then shows finded user and his reservations
	 */
public static void adminUserBySurname() {
		
		Scanner scan = new Scanner(System.in);
		User user = new User();
							
			System.out.println("Input user surname, or 'quit' to end :");
			String command = scan.nextLine();
			
			while(!command.equals("quit")) {
				
					user = User.readSurname(command);	
					
					if (user.getId()==null) {
						System.out.println("No such user.");
					}
					else {
						System.out.println(user);
						
						System.out.println("Reservations for " + user.getName() + ":");
						
						Reservation.loadReservationsUserId(user.getId());
						
						System.out.println(ArrayUtils.toString(Reservation.loadReservationsUserId(user.getId())));
					}
				
					System.out.println("Input user surname, or 'quit' to end :");
					command = scan.nextLine();
								
					
			}
								
			scan.close();
		}

}