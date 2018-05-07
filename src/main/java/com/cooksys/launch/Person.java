package com.cooksys.launch;

import java.util.Set;

public class Person {
	
	private Long id;
	private String firstname;
	private String lastname;
	private Integer age;
	private Location location;
	private Set<Interest> interests;
	
	
	public Person() {
	}


	public Person(String firstname, String lastname, Integer age) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}
	
	
	public Person(Long id, String firstname, String lastname, Integer age) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}

	
	public Person(Long id, String firstname, String lastname, Integer age, Location location, Set<Interest> interests) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.location = location;
		this.interests = interests;
	}


	public Person(String firstname, String lastname, Integer age, Location location, Set<Interest> interests) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.location = location;
		this.interests = interests;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	public Set<Interest> getInterests() {
		return interests;
	}


	public void setInterests(Set<Interest> interests) {
		this.interests = interests;
	}

	
}
