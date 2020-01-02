package com.userFront.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
	//Here we list all of the private fields. This is an example of encapsulation.

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "userId", nullable = false, updatable = false)
		private Long userId;
		private String userName;
		private String password;
		private String firstName;
		private String lastName;

		@Column(name = "email", nullable = false, unique = true)
		private String email;
		private String phone;
		
		private boolean enabled=true;

		@OneToOne
		private PrimaryAccount primaryAccount;

		@OneToOne
		private SavingsAccount savingsAccount;

		@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JsonIgnore
		private List<Appointment> appointmentList;

		@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		private List<Recipient> recipientList;
		
		//-----------------------------------------------------------------------------------------------------------
		//Here We auto generate accessors and modifiers for the private fields. 
		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
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

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public PrimaryAccount getPrimaryAccount() {
			return primaryAccount;
		}

		public void setPrimaryAccount(PrimaryAccount primaryAccount) {
			this.primaryAccount = primaryAccount;
		}

		public SavingsAccount getSavingsAccount() {
			return savingsAccount;
		}

		public void setSavingsAccount(SavingsAccount savingsAccount) {
			this.savingsAccount = savingsAccount;
		}

		public List<Appointment> getAppointmentList() {
			return appointmentList;
		}

		public void setAppointmentList(List<Appointment> appointmentList) {
			this.appointmentList = appointmentList;
		}

		public List<Recipient> getRecipientList() {
			return recipientList;
		}

		public void setRecipientList(List<Recipient> recipientList) {
			this.recipientList = recipientList;
		}

		
		//---------------------------------------------------------------------------------------------------------------
		//Here we auto generate the toString method
		
		@Override
		public String toString() {
			return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", firstName="
					+ firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + ", enabled="
					+ enabled + "]";
		}
}
