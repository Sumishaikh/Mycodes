package com;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StoredProcedures {
	
	public static void main(String[] args) {
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcmypractice", "root",
				"root")) {

			CallableStatement prepareCall = con.prepareCall("CALL selectData()");

			ResultSet result = prepareCall.executeQuery();
			
			while(result.next()) {
			    	System.out.println(result.getInt("oid"));
			    	System.out.println(result.getString("name"));
			    	System.out.println(result.getDouble("price"));
			    	
			    	System.out.println();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
