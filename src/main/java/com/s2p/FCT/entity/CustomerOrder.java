//package com.s2p.FCT.entity;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.UUID;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//
//@Entity
//public class CustomerOrder {
//	
//	@Id
//	private String id;
//	private String userId;
//	private String productId;
//	private int quantity;
//	private String productName;
//	private String productCategory;
//	private String userName;
//	private LocalDate orderedDate;
//	private String Status;
//	public CustomerOrder() {
//		this.id = UUID.randomUUID().toString(); 
//	}
//	public String getUserId() {
//		return userId;
//	}
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//	public String getProductId() {
//		return productId;
//	}
//	public void setProductId(String productId) {
//		this.productId = productId;
//	}
//	public int getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//	public String getProductName() {
//		return productName;
//	}
//	public void setProductName(String productName) {
//		this.productName = productName;
//	}
//	public String getProductCategory() {
//		return productCategory;
//	}
//	public void setProductCategory(String productCategory) {
//		this.productCategory = productCategory;
//	}
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//	public LocalDate getOrderedDate() {
//		return orderedDate;
//	}
//	public void setOrderedDate(LocalDate orderedDate) {
//		this.orderedDate = orderedDate;
//	}
//	public String getStatus() {
//		return Status;
//	}
//	public void setStatus(String status) {
//		Status = status;
//	}
//	public String getId() {
//		return id;
//	}
//	public Customers getCustomerById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public List<Customers> getAllCustomers() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public Customers updateCustomer(Long id, Customers updatedData) {
//	    Customers existing = customersRepository.findById(id)
//	        .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));
//
//			    // Only update fields you allow to change
//			    existing.setFirstName(updatedData.getFirstName());
//			    existing.setEmail(updatedData.getEmail());
//			    // ...other setters...
//
//			    return customersRepository.save(existing);
//	}
//	public void deleteCustomer(Long id2) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	
//	
//	
//
//}
