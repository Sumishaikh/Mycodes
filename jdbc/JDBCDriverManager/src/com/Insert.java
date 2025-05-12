package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert {
	
	public static void main(String[] args) {
		
		Scanner sc = new  Scanner(System.in);
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractice?useSSL=false&autoReconnect=true", "root","root")){
			
			PreparedStatement stmt = con.prepareStatement("insert into orders values(?,?)");
			
			System.out.println("Enter order id:");
			stmt.setInt(1, sc.nextInt());
			
			System.out.println("Enter order name:");
			stmt.setString(2, sc.next());
			
			int executeUpdate = stmt.executeUpdate();
			
			if(executeUpdate > 0) {
				System.out.println("Inserted successfully");
			}else {
				System.out.println("not inserted successfully");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
