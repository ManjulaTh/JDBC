package com.cooksys.launch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class PersonDao {
	
	public static Person getById(Long id) {
		
		Connection connection = getConnection();
		Person person = null;
		
		try {
			
			Statement statement = connection.createStatement();

			ResultSet result = statement.executeQuery("SELECT * FROM person_interest.people WHERE people.id = "+id);
			result.next();
			
			person = new Person(result.getString(2),result.getString(3), result.getInt(4));
			person.setId(result.getLong(1));
			
			connection.close();
			
		}catch(Exception e) {
			System.out.println("Get Person Query Failed");
			e.printStackTrace();
		}
		
		return person;
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
	
	public static void update(Person person) {
		Connection connection = getConnection();
		
		try {
			connection.createStatement().executeUpdate("UPDATE person_interest.people SET first_name = '"+person.getFirstname()
					+ "',last_name = '"+person.getLastname()+"',age = "+person.getAge()+
						" WHERE id = "+person.getId());
			connection.close();
			
		}catch(Exception e) {
			System.out.println("Update failed");
			e.printStackTrace();
		}
	}

	public static void save(Person newPerson)  {
			Connection connection = getConnection();
			Boolean match = false;
			
			if (newPerson.getId() == null) {
			
				try {
					connection.createStatement().executeUpdate("INSERT INTO person_interest.people (first_name,last_name,age) VALUES "
							+ "('"+ newPerson.getFirstname()+"','"+ newPerson.getLastname()+"',"+newPerson.getAge()+")");
					
					connection.close();
				}catch(Exception e) {
					System.out.println("Save failed");
					e.printStackTrace();
				}
			}else {
				try {
					ResultSet result = connection.createStatement().executeQuery("SELECT id FROM person_interest.people");
					while(result.next()) {
						if(newPerson.getId() == result.getLong(1)) {
							match = true;
							update(newPerson);
							break;
						}
					}
				}catch(Exception e) {
					System.out.println("Not able to retrieve ids from people table");
					e.printStackTrace();
				}
				
				if(!match) {
					try {
						throw new Exception();
					} catch (Exception e) {
						System.out.println("Person with id " + newPerson.getId()+ " doesn't exist in the records to update.\nIf you want to add new person remove id value.");
						e.printStackTrace();
					}
				}
			}
			
	}

	public static Set<Person> findInterestGroup(int interestId, int locationId){
		Connection connection = getConnection();
		Set<Person> people = new HashSet<Person>();
		
		try {
			ResultSet result = connection.createStatement().executeQuery("SELECT * FROM person_interest.findinterestgroup("+interestId+","+locationId+")");
		
			while(result.next()) {
				Person person = new Person();				
				person.setId((long)(result.getLong(1)));
				person.setFirstname(result.getString(2));
				person.setLastname(result.getString(3));
				System.out.println(result.getLong(1));
				System.out.println(result.getString(2));
				System.out.println(result.getString(3));
				people.add(person);
				
			}
			connection.close();			
		}catch(Exception e){
			System.out.println("Execution of findInterestGroup function failed ");
			e.printStackTrace();
		}
		return people;
	}
}