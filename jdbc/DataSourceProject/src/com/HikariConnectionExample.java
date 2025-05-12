// needs  java11+ slf4j  jars --> practice in someone else  pc
package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariConnectionExample {

	public static void main(String[] args) {

		// configuring connection pool

		HikariDataSource datasource = new HikariDataSource(setConnectionPool());

		Scanner sc = new Scanner(System.in);
		try (Connection con = datasource.getConnection()) {

			PreparedStatement stmt = con.prepareStatement("insert into orders values(?,?)");

			System.out.println("Enter order id:");
			stmt.setInt(1, sc.nextInt());

			System.out.println("Enter order name:");
			stmt.setString(2, sc.next());

			int executeUpdate = stmt.executeUpdate();

			if (executeUpdate > 0) {
				System.out.println("Inserted successfully");
			} else {
				System.out.println("not inserted successfully");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static HikariConfig setConnectionPool() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("com.mysql.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://localhost:3306/jdbcpractice?useSSL=false&autoReconnect=true");
		config.setUsername("root");
		config.setPassword("root");

		// Pool configuration (optional)
		config.setMaximumPoolSize(10);
		config.setMinimumIdle(5);
		config.setConnectionTimeout(30000); // 30 seconds
		config.setIdleTimeout(600000); // 10 minutes
		config.setMaxLifetime(1800000); // 30 minutes

		return config;
	}

}
