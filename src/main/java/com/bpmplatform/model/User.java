package com.bpmplatform.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	@Column(name = "email")
	@Email//(message = "*Please provide a valid Email")
	@NotEmpty//(message = "*Please provide an email")
	private String email;
	@Column(name = "password")
	@Length(min = 5,  message = "*Your password must have at least 5 characters")
	@NotEmpty//(message = "*Please provide your password")
	@Transient
	private String password;
	@Column(name = "first_name")
	@NotEmpty(message = "*Please provide your first name")
	private String firstName;
	@Column(name = "last_name")
	@NotEmpty(message = "*Please provide your last name")
	private String lastName;
	@Column(name = "active")
	private int active;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	@Column(name = "contact_number")
	@NotEmpty
	private String contactNo;
	@Column(name = "companyname")
	@NotEmpty//(message = "*Please provide your company name")
	private String companyName;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_notification", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "notification_id"))
	private Set<NotificationDetails> notificationDetails;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public Set<NotificationDetails> getNotificationDetails() {
		return notificationDetails;
	}

	public void setNotificationDetails(Set<NotificationDetails> notificationDetails) {
		this.notificationDetails = notificationDetails;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
    
}
