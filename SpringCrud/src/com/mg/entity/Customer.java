package com.mg.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="coustomer")
public class Customer implements Serializable {
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
	private int id;
	@Column(name = "firstName")
     private String fname;
	@Column(name = "lastName")
    private String lname;
	@Column(name = "email")
    private String email;
	

	public Customer() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
