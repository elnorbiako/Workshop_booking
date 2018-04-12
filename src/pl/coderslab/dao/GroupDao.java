package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pl.coderslab.entity.Group;
import pl.coderslab.entity.User;

public class GroupDao {
	
	private static final String READ_GROUP_QUERY = "Select * from user_group where id = ?";
	private static final String DELETE_GROUP_QUERY = "DELETE FROM user_group where id = ?";
	private static final String CREATE_GROUP_QUERY = "INSERT INTO user_group (name) VALUES (?)";
	private static final String FIND_ALL_GROUPS_QUERY = "SELECT * FROM user_group";
	private static final String UPDATE_GROUP_QUERY = "UPDATE user_group SET name = ? WHERE id = ?";



	
	public static void delete(Integer groupId) {
		try (Connection connection = DbUtil.getConnection();
	        PreparedStatement statement =
	                connection.prepareStatement(DELETE_GROUP_QUERY);) {
	        statement.setInt(1, groupId);
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Something went wrong...");
	    }
	}
	
	public static void add(Group group) {
	    try (Connection connection = DbUtil.getConnection();
	        PreparedStatement statement = connection.prepareStatement(CREATE_GROUP_QUERY);) {
	    	
	        statement.setString(1, group.getName());
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Something went wrong...");
	    }
	}
	
	public static Group[] loadAllGroups() {
		ArrayList<Group> groups = new ArrayList<Group>();
		try (Connection connection = DbUtil.getConnection();
			PreparedStatement statement = connection.prepareStatement(FIND_ALL_GROUPS_QUERY);) {
		    		    
		    ResultSet resultSet = statement.executeQuery();
		    while (resultSet.next()) {
		        Group loadedGroup = new Group();
		        loadedGroup.setId(resultSet.getInt("id"));
		        loadedGroup.setName(resultSet.getString("name"));
		        
		        groups.add(loadedGroup);}
		        
		} catch (Exception e) { e.printStackTrace();
        System.out.println("Something went wrong...");}
		    Group[] uArray = new Group[groups.size()]; uArray = groups.toArray(uArray);
		    return uArray;}
	
	
	public static void update(Group group) {
	    try (Connection connection = DbUtil.getConnection();
	        PreparedStatement statement = connection.prepareStatement(UPDATE_GROUP_QUERY);) {
	        statement.setInt(2, group.getId());
	        statement.setString(1, group.getName());
	        
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Something went wrong...");
	    }
	 
	}	
	

	public static Group read(Integer groupId) {
	    Group group = new Group();
	    try (Connection connection = DbUtil.getConnection();
	    PreparedStatement statement = connection.prepareStatement(READ_GROUP_QUERY);) {
	        statement.setInt(1, groupId);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                group.setId(resultSet.getInt("id"));
	                group.setName(resultSet.getString("name"));}
	        }
	                
	    } catch (Exception e) { e.printStackTrace();
	        System.out.println("Something went wrong...");}
	    return group; }
}


