package com.example.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by daiLlew on 30/09/2015.
 */
public class User {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String emailAddress;

	/**
	 * Construct a user with no values populated.
	 */
	public User() {}

	/**
	 * Constructs a new User and populates the fields with the provided values.
	 * @param firstName the user first name.
	 * @param lastName the user last name.
	 * @param emailAddress the user email address.
	 */
	public User(String firstName, String lastName, String emailAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", emailAddress='" + emailAddress + '\'' +
				'}';
	}
}
