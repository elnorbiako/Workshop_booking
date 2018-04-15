package pl.coderslab.entity;

import pl.coderslab.dao.HotelDao;

public class Hotel extends HotelDao {
	
	
    
    private Integer id;
    private String name; 
    private String address;
    private int phone;
    private int pets;
    private String description;
    
    
	public Hotel(String name, String address, int phone, int pets, String description) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.pets = pets;
		this.description = description;
	}
	
	
	public Hotel() {
		super();
	}





	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public int getPets() {
		return pets;
	}


	public void setPets(int pets) {
		this.pets = pets;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", pets=" + pets
				+ ", description=" + description + "] +\n";
	}
	
	
    
    
    

}
