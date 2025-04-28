package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractice?useSSL=false&autoReconnect=true", "root",
				"root")) {

			// since execute return resultset so after creating table it is not returnign
			// anything

			Statement createStatement = connection.createStatement();

			int query = createStatement.executeUpdate("create table orders(oid int,name varchar(20))");

			System.out.println(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
