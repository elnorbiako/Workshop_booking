package pl.coderslab.entity;

import java.util.Arrays;

public class Main1{
	
	public static void main(String[] args) {
		
		
		User user = new User();
		
		user = User.read(3);
		
		System.out.println(user);
				
		
	}
}