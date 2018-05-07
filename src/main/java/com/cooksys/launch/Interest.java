package com.cooksys.launch;

public class Interest {
	private Long id;
	private String title;
	
	//Constructors
	public Interest() {
	}	
	
	public Interest(String title) {
		this.title = title;
	}

	public Interest(Long id, String title) {
		this.id = id;
		this.title = title;
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
