package pl.coderslab.entity;

import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

public class Main3 {
	
	
	public static void main(String[] args) {
		
		adminMenuHotel();		
		
	}

/**
 * application: Admin menu for managing hotels
 */
	public static void adminMenuHotel() {
		
			Scanner scan = new Scanner(System.in);
		
			System.out.println("Hotel list: ");
			System.out.println(ArrayUtils.toString(Hotel.loadAllHotels()));	
				
			System.out.println("Choose option: 'add' 'edit' 'delete' for users, or 'quit' to end :");
			String command = scan.nextLine();
			
			while(!command.equals("quit")) {
				
				
				try {
					
					if (command.equals("add")) {
					
						System.out.println("New hotel name:");
						String name = scan.nextLine();
						
						System.out.println("Address for " + name + " :");
						String address = scan.nextLine();
						
						System.out.println("Phone for " + name + " :");
						int phone = scan.nextInt();
						scan.nextLine();
												
						System.out.println("Set pets for " + name + " :");
						int pets = scan.nextInt();
						scan.nextLine();
						
						System.out.println("Description for " + name + " :");
						String description = scan.nextLine();
						
						Hotel hotel = new Hotel(name, address, phone, pets, description);
						
						Hotel.add(hotel);			
					}
					
					else if (command.equals("edit")) {
						
						System.out.println("Hotel Id to edit:");
						int hotelId = scan.nextInt();
						scan.nextLine();
						
						System.out.println("New hotel name:");
						String name = scan.nextLine();
						
						System.out.println("Address for " + name + " :");
						String address = scan.nextLine();
						
						System.out.println("Phone for " + name + " :");
						int phone = scan.nextInt();
						scan.nextLine();
												
						System.out.println("Set pets for " + name + " :");
						int pets = scan.nextInt();
						scan.nextLine();
						
						System.out.println("Description for " + name + " :");
						String description = scan.nextLine();
						
						Hotel editHotel= Hotel.read(hotelId);
						
						editHotel.setName(name);
						editHotel.setAddress(address);
						editHotel.setPhone(phone);
						editHotel.setPets(pets);
						editHotel.setDescription(description);

						
						Hotel.update(editHotel);
					}
					
					else if (command.equals("delete")) {
						
						System.out.println("Hotel Id to delete:");
						int hotelId = scan.nextInt();
						
						Hotel.delete(hotelId);		
					}
					else{
						System.out.println("Please try again");
						}
											
				} catch (NumberFormatException e) {
					System.out.println("Not a number: " + e.getMessage());
				}
				
				
				
				System.out.println("Hotel list: ");
				System.out.println(ArrayUtils.toString(Hotel.loadAllHotels()));	
					
				System.out.println("Choose option: 'add' 'edit' 'delete' for users, or 'quit' to end :");
				command = scan.nextLine();
			}
								
			scan.close();
		}
							    
		
}


	