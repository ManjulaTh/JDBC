package com.cooksys.launch;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class LocationDao {

	public static Location getById(long id) {

				
				Connection connection = getConnection();
				Location location = null;
				
				try {
					
					ResultSet result = connection.createStatement().executeQuery("SELECT * FROM person_interest.location Where id ="+id);
					result.next();
					
					location = new Location(result.getString(2),result.getString(3),result.getString(4));
					location.setId(result.getLong(1));
					
					connection.close();
					
				}catch(Exception e) {
					System.out.println("GetInterest Query failed");
					e.printStackTrace();
				}
				return location;
			}
			
			public static void save(Location newLocation) {
				Connection connection = getConnection();
				Boolean match = false;
				
				if(newLocation.getId() == null) {
					try {
						connection.createStatement().executeUpdate("INSERT INTO person_interest.location (city,state,country) VALUES "
								+ "('"+newLocation.getCity()+"','"+newLocation.getState()+"','"+newLocation.getCountry()+"')");
						connection.close();
					}
					catch(Exception e) {
						System.out.println("Saving new Location failed");
						e.printStackTrace();
					}
				}else {
					try {
						ResultSet result = connection.createStatement().executeQuery("SELECT id FROM person_interest.location");
						while(result.next()) {
							if(newLocation.getId() == result.getLong(1)) {
								match = true;
								update(newLocation);
								break;
							}
						}
					}catch(Exception e) {
						System.out.println("Not able to retreive Ids from location table while saving ");
						e.printStackTrace();
					}
					
					if(!match) {
						try {
							throw new Exception();
						}catch(Exception e) {
							System.out.println("Location with id "+newLocation.getId() +" doesn't exist to update.\n To add new location remove id value");
							e.printStackTrace();
						}
					}
				}
				
			}

			public static void update(Location newLocation) {
				Connection connection = getConnection();
				
				try {
					connection.createStatement().executeUpdate("UPDATE person_interest.location SET city = '"+newLocation.getCity()+
							"', state = '"+newLocation.getState()+"', country = '"+newLocation.getCountry()+"' WHERE id = "+newLocation.getId());
					connection.close();
					
				}catch(Exception e) {
					System.out.println("Update of location failed");
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
