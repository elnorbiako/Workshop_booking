package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pl.coderslab.entity.Hotel;
import pl.coderslab.entity.Room;

public class RoomDao {
	
	
	private static final String CREATE_ROOM_QUERY = "INSERT INTO room(room_number,max_guest,description,price,hotel_id) VALUES (?,?,?,?,?)";
	private static final String READ_ROOM_QUERY = "Select * from room where id = ?";
	private static final String READ_ROOM_BY_HOTELID_QUERY = "Select * from room where hotel_id = ?";
	private static final String UPDATE_ROOM_QUERY = "UPDATE room SET room_number = ? , max_guest = ?, description = ?, price = ?, hotel_id = ? WHERE id = ?";
	private static final String UPDATE_ROOM_HOTELID_QUERY = "UPDATE room SET hotel_id = ? WHERE id = ?";
	private static final String DELETE_ROOM_QUERY = "DELETE FROM room where id = ?";
	private static final String FIND_ALL_ROOM_QUERY = "SELECT * FROM room";
	
	
	
	public static void delete(Integer roomId) {
		try (Connection connection = DbUtil.getConnection();
	        PreparedStatement statement =
	                connection.prepareStatement(DELETE_ROOM_QUERY);) {
	        statement.setInt(1, roomId);
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Something went wrong...");
	    }
	}
	
	public static Room read(Integer roomId) {
		Room room = new Room();
	    try (Connection connection = DbUtil.getConnection();
	    PreparedStatement statement = connection.prepareStatement(READ_ROOM_QUERY);) {
	        statement.setInt(1, roomId);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	            	room.setId(resultSet.getInt("id"));
	            	room.setNumber(resultSet.getInt("room_number"));
	            	room.setMaxGuest(resultSet.getInt("max_guest"));
	            	room.setDescription(resultSet.getString("description"));
	            	room.setPrice(resultSet.getDouble("price")); 
	            	room.setHotelId(resultSet.getInt("hotel_id"));}}
	        		
	    } catch (Exception e) { e.printStackTrace();
	        System.out.println("Something went wrong...");}
	    return room;
	}
	
	
	public static void update(Room room) {
	    try (Connection connection = DbUtil.getConnection();
	        PreparedStatement statement = connection.prepareStatement(UPDATE_ROOM_QUERY);) {
	        statement.setInt(6, room.getId());
	        statement.setInt(1, room.getNumber());
	        statement.setInt(2, room.getMaxGuest());
	        statement.setString(3, room.getDescription());
	        statement.setDouble(4, room.getPrice());
	        statement.setInt(5, room.getHotelId());
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Something went wrong...");
	    }
	 
	}
	
	
	public static Room[] loadAllRooms() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		try (Connection connection = DbUtil.getConnection();
			PreparedStatement statement = connection.prepareStatement(FIND_ALL_ROOM_QUERY);) {
		    		    
		    ResultSet resultSet = statement.executeQuery();
		    while (resultSet.next()) {
		        Room loadedRoom = new Room();
		        loadedRoom.setId(resultSet.getInt("id"));
		        loadedRoom.setNumber(resultSet.getInt("room_number"));
		        loadedRoom.setMaxGuest(resultSet.getInt("max_guest"));
		        loadedRoom.setDescription(resultSet.getString("description"));
		        loadedRoom.setPrice(resultSet.getDouble("price")); 
		        loadedRoom.setHotelId(resultSet.getInt("hotel_id"));
		        rooms.add(loadedRoom);}
		        
		} catch (Exception e) { e.printStackTrace();
        System.out.println("Something went wrong...");}
			Room[] uArray = new Room[rooms.size()]; uArray = rooms.toArray(uArray);
		    return uArray;
		    }
		    
		    	
		    
	
	public static void add(Room room) {
	    try (Connection connection = DbUtil.getConnection();
	        PreparedStatement statement = connection.prepareStatement(CREATE_ROOM_QUERY);) {
	    	
	        statement.setInt(1, room.getNumber());
	        statement.setInt(2, room.getMaxGuest());
	        statement.setString(3, room.getDescription());
	        statement.setDouble(4, room.getPrice());
	        statement.setInt(5, room.getHotelId());
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Something went wrong...");
	    }
	}

}


