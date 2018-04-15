package pl.coderslab.entity;

import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

public class Main6{
	
	public static void main(String[] args) {

		
		Reservation reserv = new Reservation("2018-05-05", "2018-05-13", "Nie będzie niczego",1,4,3 );
		Reservation.add(reserv);
		
		
	}
}