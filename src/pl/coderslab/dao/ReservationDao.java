package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pl.coderslab.entity.Reservation;


public class ReservationDao {
	
	private static final String CREATE_RESERVATION_QUERY = "INSERT INTO reservation(created,date_from,date_to,description,status_id,users_id,room_id) VALUES (NOW(),?,?,?,?,?,?)";
	private static final String READ_RESERVATION_QUERY = "Select * from reservation where id = ?";
	private static final String READ_RESERVATION_BY_USERID_QUERY = "Select * from reservation where users_id = ?";
	private static final String UPDATE_RESERVATION_QUERY = "UPDATE reservation SET date_from = ? , date_to = ?, description = ?, status_id = ?, users_id = ?, room_id = ? WHERE id = ?";
	private static final String UPDATE_RESERVATION_STATUSID_QUERY = "UPDATE reservation SET status_id = ? WHERE id = ?";
	private static final String DELETE_RESERVATION_QUERY = "DELETE FROM reservation where id = ?";
	private static final String FIND_ALL_RESERVATION_QUERY = "SELECT * FROM reservation";
	
	
	
	
	
	public static void delete(Integer reservationId) {
		try (Connection connection = DbUtil.getConnection();
	        PreparedStatement statement =
	                connection.prepareStatement(DELETE_RESERVATION_QUERY);) {
	        statement.setInt(1, reservationId);
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Something went wrong...");
	    }
	}
	
	public static Reservation read(Integer reservationId) {
		Reservation reserv = new Reservation();
	    try (Connection connection = DbUtil.getConnection();
	    PreparedStatement statement = connection.prepareStatement(READ_RESERVATION_QUERY);) {
	        statement.setInt(1, reservationId);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	            	reserv.setId(resultSet.getInt("id"));
	            	reserv.setCreated(resultSet.getDate("created"));
	            	reserv.setDateFrom(resultSet.getString("date_from"));
	            	reserv.setDateTo(resultSet.getString("date_to"));
	            	reserv.setDescription(resultSet.getString("description"));
	            	reserv.setStatusId(resultSet.getInt("status_id")); 
	            	reserv.setUserId(resultSet.getInt("users_id")); 
	            	reserv.setRoomId(resultSet.getInt("room_id"));}}
	        		
	    } catch (Exception e) { e.printStackTrace();
	        System.out.println("Something went wrong...");}
	    return reserv;
	}
	
	
	public static void update(Reservation reserv) {
	    try (Connection connection = DbUtil.getConnection();
	        PreparedStatement statement = connection.prepareStatement(UPDATE_RESERVATION_QUERY);) {
	        statement.setInt(7, reserv.getId());
	        statement.setString(1, reserv.getDateFrom());
	        statement.setString(2, reserv.getDateTo());
	        statement.setString(3, reserv.getDescription());
	        statement.setInt(4, reserv.getStatusId());
	        statement.setInt(5, reserv.getUserId());
	        statement.setInt(6, reserv.getRoomId());
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Something went wrong...");
	    }
	 
	}
	
	
	public static Reservation[] loadAllReservations() {
		ArrayList<Reservation> reservs = new ArrayList<Reservation>();
		try (Connection connection = DbUtil.getConnection();
			PreparedStatement statement = connection.prepareStatement(FIND_ALL_RESERVATION_QUERY);) {
		    		    
		    ResultSet resultSet = statement.executeQuery();
		    while (resultSet.next()) {
		    	Reservation loadedReserv = new Reservation();
		        loadedReserv.setId(resultSet.getInt("id"));
		        loadedReserv.setCreated(resultSet.getDate("created"));
		        loadedReserv.setDateFrom(resultSet.getString("date_from"));
		        loadedReserv.setDateTo(resultSet.getString("date_to"));
		        loadedReserv.setDescription(resultSet.getString("description"));
		        loadedReserv.setStatusId(resultSet.getInt("status_id"));
		        loadedReserv.setUserId(resultSet.getInt("users_id"));
		        loadedReserv.setRoomId(resultSet.getInt("room_id"));
		        reservs.add(loadedReserv);}
		        
		} catch (Exception e) { e.printStackTrace();
        System.out.println("Something went wrong...");}
		Reservation[] uArray = new Reservation[reservs.size()]; uArray = reservs.toArray(uArray);
		    return uArray;
		    }
		    
		    	
		    
	
	public static void add(Reservation reserv) {
	    try (Connection connection = DbUtil.getConnection();
	        PreparedStatement statement = connection.prepareStatement(CREATE_RESERVATION_QUERY);) {
	    	
	        statement.setString(1, reserv.getDateFrom());
	        statement.setString(2, reserv.getDateTo());
	        statement.setString(3, reserv.getDescription());
	        statement.setInt(4, reserv.getStatusId());
	        statement.setInt(5, reserv.getUserId());
	        statement.setInt(6, reserv.getRoomId());
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Something went wrong...");
	    }
	}

}




