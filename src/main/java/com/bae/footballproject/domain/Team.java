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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((captain == null) ? 0 : captain.hashCode());
		result = prime * result + ((contactDetails == null) ? 0 : contactDetails.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kitColour == null) ? 0 : kitColour.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + squadSize;
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (captain == null) {
			if (other.captain != null)
				return false;
		} else if (!captain.equals(other.captain))
			return false;
		if (contactDetails == null) {
			if (other.contactDetails != null)
				return false;
		} else if (!contactDetails.equals(other.contactDetails))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kitColour == null) {
			if (other.kitColour != null)
				return false;
		} else if (!kitColour.equals(other.kitColour))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (squadSize != other.squadSize)
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}	
	
	
	
}
