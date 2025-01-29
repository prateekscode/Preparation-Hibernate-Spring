package com.tutorial;

import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name="student_address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressId;
	@Column(length = 50,name = "STREET")
	private String street;
	@Column(length = 100,name = "CITY")
	private String city;
	@Column(name = "is_open")
	private boolean isOpen;
	@Transient
	private double x;
	@Column(length = 50,name = "added_date")
	@Temporal(TemporalType.DATE)
	private Date addedDate;

	/*
	 * Make sure the image column in MySQL database is of type BLOB or
	 * LONGBLOB, depending on the size of the data:
	 * 
	 * sql query-->ALTER TABLE student_address MODIFY COLUMN image LONGBLOB;
	 * 
	 * TINYBLOB – Max 255 bytes 
	 * BLOB – Max 65 KB 
	 * MEDIUMBLOB – Max 16 MB 
	 * LONGBLOB – Max 4 GB (Recommended for large images) 
	 * 
	 * @Lob
	 * @Column(columnDefinition = "LONGBLOB") 
	 * private byte[] image;
	 */
	@Lob
    @Column(columnDefinition = "LONGBLOB")
	private byte[] image;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int addressId, String street, String city, boolean isOpen, double x, Date addedDate, byte[] image) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		this.x = x;
		this.addedDate = addedDate;
		this.image = image;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
}
