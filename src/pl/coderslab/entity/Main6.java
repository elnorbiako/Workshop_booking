package pl.coderslab.entity;

import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

public class Main6{
	
	public static void main(String[] args) {

		userMenuReserv();		
		
	}
	/**
	 * User menu for adding reservations (with user id, room id, date from and to, description)
	 */
	public static void userMenuReserv() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Room list: ");
		System.out.println(ArrayUtils.toString(Room.loadAllRooms()));	
		
		System.out.println("Choose option: 'add' to create new reservation, or 'quit' to end :");
		String command = scan.nextLine();
		
		while(!command.equals("quit")) {
			
			try {			
										
				if (command.equals("add")) {
					
					System.out.println("User id:");
					int userId = scan.nextInt();
					scan.nextLine();
					
					System.out.println("Room id:");
					int roomId = scan.nextInt();
					scan.nextLine();
					
					System.out.println("Start date (yyyy-mm-dd):");
					String dateFrom = scan.nextLine();
					
					System.out.println("End date (yyyy-mm-dd):");
					String dateTo = scan.nextLine();
					
					System.out.println("Additional informations:");
					String description = scan.nextLine();
					
					Reservation reserv = new Reservation(dateFrom, dateTo, description, 1, userId, roomId);
					
					Reservation.add(reserv);
					
				} else {
					System.out.println("Please try again.");
					}
				
			} catch (NumberFormatException e) {
				System.out.println("Not a number!");
			}
								
			System.out.println("Reservation list: ");
			System.out.println(ArrayUtils.toString(Reservation.loadAllReservations()));	
			System.out.println("Choose option: 'add' to create new reservation, or 'quit' to end :");
			command = scan.nextLine();
				}
		scan.close();
		}
}

					
