package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pl.coderslab.entity.Group;
import pl.coderslab.entity.Status;

public class StatusDao {
	

	
	
	private static final String DELETE_STATUS_QUERY = "DELETE FROM status where id = ?";
	private static final String CREATE_STATUS_QUERY = "INSERT INTO status (name) VALUES (?)";
	private static final String FIND_ALL_STATUS_QUERY = "SELECT * FROM status";
	private static final String UPDATE_STATUS_QUERY = "UPDATE status SET name = ? WHERE id = ?";
	private static final String READ_STATUS_QUERY = "Select * from status where id = ?";



	
	public static void delete(Integer statusId) {
		try (Connection connection = DbUtil.getConnection();
	        PreparedStatement statement =
	                connection.prepareStatement(DELETE_STATUS_QUERY);) {
	        statement.setInt(1, statusId);
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Something went wrong...");
	    }
	}
	
	public static void add(Status status) {
	    try (Connection connection = DbUtil.getConnection();
	        PreparedStatement statement = connection.prepareStatement(CREATE_STATUS_QUERY);) {
	    	
	        statement.setString(1, status.getName());
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Something went wrong...");
	    }
	}
	
	public static Status[] loadAllStatus() {
		ArrayList<Status> status = new ArrayList<Status>();
		try (Connection connection = DbUtil.getConnection();
			PreparedStatement statement = connection.prepareStatement(FIND_ALL_STATUS_QUERY);) {
		    		    
		    ResultSet resultSet = statement.executeQuery();
		    while (resultSet.next()) {
		    	Status loadedStatus = new Status();
		    	loadedStatus.setId(resultSet.getInt("id"));
		    	loadedStatus.setName(resultSet.getString("name"));
		        
		        status.add(loadedStatus);}
		        
		} catch (Exception e) { e.printStackTrace();
        System.out.println("Something went wrong...");}
		    Status[] uArray = new Status[status.size()]; uArray = status.toArray(uArray);
		    return uArray;}
	
	
	public static void update(Status status) {
	    try (Connection connection = DbUtil.getConnection();
	        PreparedStatement statement = connection.prepareStatement(UPDATE_STATUS_QUERY);) {
	        statement.setInt(2, status.getId());
	        statement.setString(1, status.getName());
	        
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Something went wrong...");
	    }
	 
	}	
	

	public static Group read(Integer statusId) {
	    Group group = new Group();
	    try (Connection connection = DbUtil.getConnection();
	    PreparedStatement statement = connection.prepareStatement(READ_STATUS_QUERY);) {
	        statement.setInt(1, statusId);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                group.setId(resultSet.getInt("id"));
	                group.setName(resultSet.getString("name"));}
	        }
	                
	    } catch (Exception e) { e.printStackTrace();
	        System.out.println("Something went wrong...");}
	    return group; }
}





