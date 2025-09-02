package com.s2p.FCT.entity;

import java.util.ArrayList;
// import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.s2p.FCT.model.CustomerAddress;

import jakarta.persistence.CascadeType;
// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;

@Entity
public class Customers {
	
	 	@Id		
	    private UUID id;

	    private String firstName;
	    private String lastName;
	    private String email;
	    private String password;
	    private String phoneNumber;
		private String Role;
	

	  // @OneToOne(mappedBy = "customers", cascade = CascadeType.ALL, orphanRemoval = true)
	  @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<CustomerAddress> address = new ArrayList<>();

	    public List<CustomerAddress> getAddress() {
			return address;
		}

		public void setAddress(List<CustomerAddress> address) {
			this.address = address;
		}

		@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
	    @JsonIgnore
	    private List<Order> orders;

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

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

	


		public List<Order> getOrders() {
			return orders;
		}

		public void setOrders(List<Order> orders) {
			this.orders = orders;
		}
		    

		  public String getRole() {
			return Role;
		}

		public void setRole(String role) {
			Role = "role";
		}
		
	

}
