package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pl.coderslab.entity.Hotel;
import pl.coderslab.entity.User;

public class HotelDao {
	
	
	private static final String CREATE_HOTEL_QUERY = "INSERT INTO hotel(name,address,phone,pets,description) VALUES (?,?,?,?,?)";
	private static final String READ_HOTEL_QUERY = "Select * from hotel where id = ?";
	private static final String UPDATE_HOTEL_QUERY = "UPDATE hotel SET name = ? , address = ?, phone = ?, pets = ?, description = ? WHERE id = ?";
	private static final String DELETE_HOTEL_QUERY = "DELETE FROM hotel where id = ?";
	private static final String FIND_ALL_HOTEL_QUERY = "SELECT * FROM hotel";
	
	
	
	public static void delete(Integer hotelId) {
		try (Connection connection = DbUtil.getConnection();
	        PreparedStatement statement =
	                connection.prepareStatement(DELETE_HOTEL_QUERY);) {
	        statement.setInt(1, hotelId);
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Something went wrong...");
	    }
	}
	
	public static Hotel read(Integer hotelId) {
	    Hotel hotel = new Hotel();
	    try (Connection connection = DbUtil.getConnection();
	    PreparedStatement statement = connection.prepareStatement(READ_HOTEL_QUERY);) {
	        statement.setInt(1, hotelId);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	            	hotel.setId(resultSet.getInt("id"));
	            	hotel.setName(resultSet.getString("name"));
	            	hotel.setAddress(resultSet.getString("address"));
	            	hotel.setPhone(resultSet.getInt("phone"));
	            	hotel.setPets(resultSet.getInt("pets")); 
	        		hotel.setDescription(resultSet.getString("description"));}}
	        		
	    } catch (Exception e) { e.printStackTrace();
	        System.out.println("Something went wrong...");}
	    return hotel;
	}
	
	
	public static void update(Hotel hotel) {
	    try (Connection connection = DbUtil.getConnection();
	        PreparedStatement statement = connection.prepareStatement(UPDATE_HOTEL_QUERY);) {
	        statement.setInt(6, hotel.getId());
	        statement.setString(1, hotel.getName());
	        statement.setString(2, hotel.getAddress());
	        statement.setInt(3, hotel.getPhone());
	        statement.setInt(4, hotel.getPets());
	        statement.setString(5, hotel.getDescription());
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Something went wrong...");
	    }
	 
	}
	
	
	public static Hotel[] loadAllHotels() {
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		try (Connection connection = DbUtil.getConnection();
			PreparedStatement statement = connection.prepareStatement(FIND_ALL_HOTEL_QUERY);) {
		    		    
		    ResultSet resultSet = statement.executeQuery();
		    while (resultSet.next()) {
		        Hotel loadedHotel = new Hotel();
		        loadedHotel.setId(resultSet.getInt("id"));
		        loadedHotel.setName(resultSet.getString("name"));
		        loadedHotel.setAddress(resultSet.getString("address"));
		        loadedHotel.setPhone(resultSet.getInt("phone"));
		        loadedHotel.setPets(resultSet.getInt("pets"));
		        loadedHotel.setDescription(resultSet.getString("description"));
		        hotels.add(loadedHotel);}
		        
		} catch (Exception e) { e.printStackTrace();
        System.out.println("Something went wrong...");}
			Hotel[] uArray = new Hotel[hotels.size()]; uArray = hotels.toArray(uArray);
		    return uArray;}
	
	
	public static void add(Hotel hotel) {
	    try (Connection connection = DbUtil.getConnection();
	        PreparedStatement statement = connection.prepareStatement(CREATE_HOTEL_QUERY);) {
	    	
	        statement.setString(1, hotel.getName());
	        statement.setString(2, hotel.getAddress());
	        statement.setInt(3, hotel.getPhone());
	        statement.setInt(4, hotel.getPets());
	        statement.setString(5, hotel.getDescription());
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Something went wrong...");
	    }
	}

}
