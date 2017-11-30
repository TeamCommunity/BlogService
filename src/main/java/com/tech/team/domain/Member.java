package com.tech.team.domain;

public class Member {

	public String name;

	public Member() {
		super();
	}	
	
	public Member(String name) {
		this();
		this.name = name;
	}
	
	public String getString() {
		return getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
