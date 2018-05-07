package com.cooksys.launch;

public class Location {

	private Long id ;
	private String city;
	private String country;
	private String state;
	
	//Constructors
	
	public Location() {
	}
	
	public Location(String city, String state, String country) {
		this.city = city;
		this.country = country;
		this.state = state;
	}
	
	
	public Location(Long id, String city, String state, String country) {
		this.id = id;
		this.city = city;
		this.country = country;
		this.state = state;
	}

	//Getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
