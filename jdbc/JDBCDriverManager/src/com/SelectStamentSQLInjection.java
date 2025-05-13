package com;

import java.sql.*;
import java.util.Scanner;


public class SelectStamentSQLInjection {
	
	
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        try (Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/jdbcpractice", "root", "root")) {
	            
	            System.out.println("Enter username to search:");
	            String username = sc.nextLine();
	            
	            // UNSAFE: Using Statement with string concatenation
	            Statement stmt = con.createStatement();
	            String sql = "SELECT * FROM users WHERE username = '" + username + "'";
	            
	            System.out.println("Executing: " + sql);
	            
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            if (rs.next()) {
	                System.out.println("User found:");
	                System.out.println("ID: " + rs.getInt("uid"));
	                System.out.println("Username: " + rs.getString("username"));
	              
	            } else {
	                System.out.println("User not found");
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


