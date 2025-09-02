package com.s2p.FCT.model;

import java.util.List;
import java.util.UUID;

public class CustomerModel {

	private UUID id;
    private String firstName;
    private String lastName;
    private String email;
	private String phoneNumber;

	private String role;
    
	private List<CustomerAddress> addresses;
    
    

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
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
	public List<CustomerAddress> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<CustomerAddress> addresses) {
		this.addresses = addresses;
	}
  public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
    	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
}