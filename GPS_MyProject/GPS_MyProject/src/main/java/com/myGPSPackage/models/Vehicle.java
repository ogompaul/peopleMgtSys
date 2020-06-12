package com.myGPSPackage.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long vid;
	
	@Column
	private String name;
	
	@Column
	private double regNumber;
	
	@OneToOne(mappedBy = "vehicle")
	private GPSDevice gpsDevice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customer_cid")
	private Customer customer;

	public Vehicle(long vid, String name, double regNumber, GPSDevice gpsDevice, Customer customer) {
		this.vid = vid;
		this.name = name;
		this.regNumber = regNumber;
		this.gpsDevice = gpsDevice;
		this.customer = customer;
	}
	
	public Vehicle() {
		
	}

	public long getVid() {
		return vid;
	}

	public void setVid(long vid) {
		this.vid = vid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(double regNumber) {
		this.regNumber = regNumber;
	}

	public GPSDevice getGpsDevice() {
		return gpsDevice;
	}

	public void setGpsDevice(GPSDevice gpsDevice) {
		this.gpsDevice = gpsDevice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Vehicle [vid=" + vid + ", name=" + name + ", regNumber=" + regNumber + ", gpsDevice=" + gpsDevice
				+ ", customer=" + customer + "]";
	}
	
	
	
}
