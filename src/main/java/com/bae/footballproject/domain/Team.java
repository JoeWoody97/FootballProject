package com.bae.footballproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String teamName;
	
	private String captain;
	
	private String kitColour;
	
	private int squadSize;
	
	private String location;
	
	private String contactDetails;

	public Team(String teamName, String captain, String kitColour, int squadSize, String location, String contactDetails) {
		super();
		this.teamName = teamName;
		this.captain = captain;
		this.kitColour = kitColour;
		this.squadSize = squadSize;
		this.location = location;
		this.contactDetails = contactDetails;
	}

	public Team(Long id, String teamName, String captain, String kitColour, int squadSize, String location,
			String contactDetails) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.captain = captain;
		this.kitColour = kitColour;
		this.squadSize = squadSize;
		this.location = location;
		this.contactDetails = contactDetails;
	}

	public Team() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCaptain() {
		return captain;
	}

	public void setCaptain(String captain) {
		this.captain = captain;
	}

	public String getKitColour() {
		return kitColour;
	}

	public void setKitColour(String kitColour) {
		this.kitColour = kitColour;
	}

	public int getSquadSize() {
		return squadSize;
	}

	public void setSquadSize(int squadSize) {
		this.squadSize = squadSize;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", teamName=" + teamName + ", captain=" + captain + ", kitColour=" + kitColour
				+ ", squadSize=" + squadSize + ", location=" + location + ", contactDetails=" + contactDetails + "]";
	}	
	
}
