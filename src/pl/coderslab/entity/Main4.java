package pl.coderslab.entity;

import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

public class Main4 {
	
	
	public static void main(String[] args) {
		
		adminMenuRoom();		
		
	}

/**
 * application: Admin menu for managing hotel rooms
 */
	public static void adminMenuRoom() {
		
		Scanner scan = new Scanner(System.in);
		
			
		
			System.out.println("Room list: ");
			System.out.println(ArrayUtils.toString(Room.loadAllRooms()));	
				
			System.out.println("Choose option: 'add' 'edit' 'delete' for rooms, or 'quit' to end :");
			String command = scan.nextLine();
			
			while(!command.equals("quit")) {
				
				
				try {
					
					if (command.equals("add")) {
					
						System.out.println("New room internal number:");
						int number = scan.nextInt();
						scan.nextLine();
						
						System.out.println("Maximum guests:");
						int maxGuest = scan.nextInt();
						scan.nextLine();
						
						System.out.println("Description:");
						String description = scan.nextLine();
						
						System.out.println("Price for one night:");
						double price = scan.nextDouble();
						scan.nextLine();
												
						System.out.println("Hotel Id:");
						int hotelId = scan.nextInt();
						scan.nextLine();
						
						
						
						Room room = new Room(number, maxGuest, description, price, hotelId);
						
						Room.add(room);			
					}
					
					else if (command.equals("edit")) {
						
						System.out.println("Room Id to edit:");
						int roomId = scan.nextInt();
						scan.nextLine();
						
						System.out.println("New room internal number:");
						int number = scan.nextInt();
						scan.nextLine();
						
						System.out.println("Maximum guests:");
						int maxGuest = scan.nextInt();
						scan.nextLine();
						
						System.out.println("Description:");
						String description = scan.nextLine();
						
						System.out.println("Price for one night:");
						double price = scan.nextDouble();
						scan.nextLine();
												
						System.out.println("Hotel Id:");
						int hotelId = scan.nextInt();
						scan.nextLine();
						
						Room editRoom= Room.read(roomId);
						
						editRoom.setNumber(number);
						editRoom.setMaxGuest(maxGuest);
						editRoom.setDescription(description);
						editRoom.setPrice(price);
						editRoom.setHotelId(hotelId);

						
						Room.update(editRoom);
					}
					
					else if (command.equals("delete")) {
						
						System.out.println("Room Id to delete:");
						int roomId = scan.nextInt();
						
						Room.delete(roomId);		
					}
					else{
						System.out.println("Please try again");
						}
											
				} catch (NumberFormatException e) {
					System.out.println("Not a number: " + e.getMessage());
				}
				
				
				
				System.out.println("Room list: ");
				System.out.println(ArrayUtils.toString(Room.loadAllRooms()));	
					
				System.out.println("Choose option: 'add' 'edit' 'delete' for rooms, or 'quit' to end :");
				command = scan.nextLine();
			}
								
			scan.close();
		}
							    
		
}


	