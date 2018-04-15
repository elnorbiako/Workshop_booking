package pl.coderslab.entity;

import pl.coderslab.dao.RoomDao;

public class Room extends RoomDao {
	
	
		private Integer id;
	    private int number; 
	    private int maxGuest;
	    private String description;
	    private double price;
	    private int hotelId;
	    
	    
		public Room(int number, int maxGuest, String description, double price, int hotelId) {
			super();
			
			this.number = number;
			this.maxGuest = maxGuest;
			this.description = description;
			this.price = price;
			this.hotelId = hotelId;
		}


		public Room() {
			super();
		}


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public int getNumber() {
			return number;
		}


		public void setNumber(int number) {
			this.number = number;
		}


		public int getMaxGuest() {
			return maxGuest;
		}


		public void setMaxGuest(int maxGuest) {
			this.maxGuest = maxGuest;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public double getPrice() {
			return price;
		}


		public void setPrice(double price) {
			this.price = price;
		}


		public int getHotelId() {
			return hotelId;
		}


		public void setHotelId(int hotelId) {
			this.hotelId = hotelId;
		}


		@Override
		public String toString() {
			return "Room [id=" + id + ", number=" + number + ", maxGuest=" + maxGuest + ", description=" + description
					+ ", price=" + price + ", hotelId=" + hotelId + "] +\n";
		}
	    
		
		
		
}
