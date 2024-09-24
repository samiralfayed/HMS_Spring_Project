package com.hms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringHmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHmsApplication.class, args);

		try {
			// Load MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			System.out.println("Connection established successfully.");
		} catch (ClassNotFoundException e) {
			System.out.println("Error: MySQL JDBC Driver class not found. Please add the driver dependency.");
		} catch (Exception e) {
			System.out.println("Unexpected error loading MySQL JDBC Driver: " + e.toString());
		}
    }
}
