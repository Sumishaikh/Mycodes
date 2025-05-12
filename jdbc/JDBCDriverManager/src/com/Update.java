package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcmypractice", "root",
				"root")) {

			PreparedStatement st = con.prepareStatement("update orders set price = ? where name = ?");

			System.out.println("Enter price");
			st.setInt(1, sc.nextInt());
			System.out.println("Enter name:");
			st.setString(2, sc.next());
			
			int update = st.executeUpdate();
			
			if(update > 0) {
				System.out.println("updates successfully");
			}else {
				System.out.println("not updated successfully");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
