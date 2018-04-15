package pl.coderslab.entity;

import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

public class Main5{
	
	public static void main(String[] args) {
		
		adminMenuReserv();
		
	}
	/**
	 * method for changing Status id for a given reservation
	 **/
	public static void adminMenuReserv() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Reservation list: ");
		System.out.println(ArrayUtils.toString(Reservation.loadAllReservations()));	
		
		System.out.println("Choose option: 'change' to change payment status, or 'quit' to end :");
		String command = scan.nextLine();
		
		while(!command.equals("quit")) {
			
			try {			
										
				if (command.equals("change")) {
					
					System.out.println("Reservation id:");
					int reservId = scan.nextInt();
					scan.nextLine();
					
					System.out.println("New status (1 for accepted, 2 for paid, 3 for cancelled):");
					int statusId = scan.nextInt();
					scan.nextLine();
					
					Reservation.updateStatusId(reservId, statusId);
					
				} else {
					System.out.println("Please try again.");
					}
				
			} catch (NumberFormatException e) {
				System.out.println("Not a number!");
			}
								
			System.out.println("Reservation list: ");
			System.out.println(ArrayUtils.toString(Reservation.loadAllReservations()));	
			System.out.println("Choose option: 'change' to change payment status, or 'quit' to end :");
			command = scan.nextLine();
				}
		scan.close();
		}
}

					
						
	


