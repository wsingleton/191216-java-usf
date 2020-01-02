package com.userFront.domain;

import javax.persistence.*;


import java.util.Date;

//This class will be ran as an entity. When hibernate starts to run this entity will persist
@Entity
public class Appointment {

	@Id //Indicates primary ID
	@GeneratedValue(strategy = GenerationType.AUTO) //Generates a value
	private Long id;
	private Date date;
	private String location;
	private String description;
	private boolean confirmed;

	@ManyToOne //Referring to relationship between appointments to User
	@JoinColumn(name = "user_id")
	private User user;

	//Auto generate accessors and modifiers

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Appointment{" +
				"id=" + id +
				", date=" + date +
				", location='" + location + '\'' +
				", description='" + description + '\'' +
				", confirmed=" + confirmed +
				", user=" + user +
				'}';
	}
}
