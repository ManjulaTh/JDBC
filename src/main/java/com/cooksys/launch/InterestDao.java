package com.cooksys.launch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class InterestDao {

	public static Interest getById(long id) {
		
		Connection connection = getConnection();
		Interest interest = null;
		
		try {
			
			ResultSet result = connection.createStatement().executeQuery("SELECT * FROM person_interest.interest Where id ="+id);
			result.next();
			
			interest = new Interest(result.getString(2));
			interest.setId(result.getLong(1));
			
			connection.close();
			
		}catch(Exception e) {
			System.out.println("GetInterest Query failed");
			e.printStackTrace();
		}
		return interest;
	}
	
	public static void saveInterest(Interest newInterest) {
		Connection connection = getConnection();
		Boolean match = false;
		
		if(newInterest.getId() == null) {
			try {
				connection.createStatement().executeUpdate("INSERT INTO person_interest.interest (title) VALUES ('"+newInterest.getTitle()+"')");
				connection.close();
			}
			catch(Exception e) {
				System.out.println("Saving new Interest failed");
				e.printStackTrace();
			}
		}else {
			try {
				ResultSet result = connection.createStatement().executeQuery("SELECT id FROM person_interest.interest");
				while(result.next()) {
					if(newInterest.getId() == result.getLong(1)) {
						match = true;
						update(newInterest);
						break;
					}
				}
			}catch(Exception e) {
				System.out.println("Not able to retreive Ids from interest table while saving ");
				e.printStackTrace();
			}
			
			if(!match) {
				try {
					throw new Exception();
				}catch(Exception e) {
					System.out.println("Interest with id "+newInterest.getId() +" doesn't exist to update.\n To add new Interest remove id value");
					e.printStackTrace();
				}
			}
		}
		
	}

	public static void update(Interest newInterest) {
		Connection connection = getConnection();
		
		try {
			connection.createStatement().executeUpdate("UPDATE person_interest.interest SET title = '"+newInterest.getTitle()+
					"' WHERE id = "+newInterest.getId());
			connection.close();
			
		}catch(Exception e) {
			System.out.println("Update failed");
			e.printStackTrace();
		}
		}

	public static Connection getConnection() {

		try {
			
			Class.forName("org.postgresql.Driver");			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/people_interest", "postgres","bondstone");
			connection.createStatement().executeUpdate("SET search_path = person_interest, \"$user\", public;");
			return connection;
			
		}catch (Exception e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
		}
		
		return null;
	}
}
