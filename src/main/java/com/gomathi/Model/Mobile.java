package com.gomathi.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="mobile")
public class Mobile 
{
	
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="id")
   private int id;
   
   @Column(name="name")
   private String name;
   
   @Column(name="image")
   private String image;
   
   @ManyToOne
   @JoinColumn(name="customerId")
   private Customer customer;

	public Mobile(int id, String name, String image, Customer customer) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
}