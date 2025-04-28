package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Alter {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcmypractice", "root",
				"root")) {

			Statement stmt = con.createStatement();
			stmt.execute("alter table orders add column price int");

			System.out.println("Altered table");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
