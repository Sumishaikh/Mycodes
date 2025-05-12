package com;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

public class StoredProcedures2 {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractice?useSSL=false&autoReconnect=true", "root",
				"root")) {

			CallableStatement prepareCall = con.prepareCall("CALL paramter(?,?)");

			prepareCall.setInt(1, 101);
			
			prepareCall.registerOutParameter(2, Types.VARCHAR);
			
			prepareCall.executeQuery();
			
			String name =  prepareCall.getString(2);
			System.out.println(name);

		

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
