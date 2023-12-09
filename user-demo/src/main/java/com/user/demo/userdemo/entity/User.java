package com.user.demo.userdemo.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "user_details")
@ToString
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
	@GenericGenerator(name = "native",strategy = "native")
	private Long id;
	
	private String name;
	
	private String email_id;
	
	private int phone_number;

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

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public User(Long id, String name, String email_id, int phone_number) {
		super();
		this.id = id;
		this.name = name;
		this.email_id = email_id;
		this.phone_number = phone_number;
	}
	/*
	 * public User() {
	 * 
	 * }
	 */

	/*
	 * @Override public String toString() { return "User [id=" + id + ", name=" +
	 * name + ", email_id=" + email_id + ", phone_number=" + phone_number + "]"; }
	 */
	
	
	
	

}
