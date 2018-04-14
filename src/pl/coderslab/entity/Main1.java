package pl.coderslab.entity;

import java.util.Arrays;

public class Main1{
	
	public static void main(String[] args) {
		
		
		Reservation reserv = new Reservation("2018-04-18", "2018-04-28", "test desc 2", 3, 4, 2);
		
		Reservation.add(reserv);
		
	}
}