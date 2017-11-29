package com.tech.team.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Team {

	public Team() {

	}

	public Team(String name, String location, Set<Player> players) {
		
		this.name = name;
		this.location = location;
		this.players = players;

	}

	@Id
	@GeneratedValue
	Long id;

	String name;

	String location;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "teamId")
	Set<Player> players;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

}
