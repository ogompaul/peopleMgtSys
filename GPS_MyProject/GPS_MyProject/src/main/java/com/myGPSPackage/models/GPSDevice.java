package com.myGPSPackage.models;

import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="gpsDevice")
public class GPSDevice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long gpsId;
	
	@Column
	private String manufactuer;
	
	@Column
	private int IMEI;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="vehicle_vid")
	private Vehicle vehicle;
	
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "gpsDevice")
	private Customer customer;

	public GPSDevice(long gpsId, String manufactuer, int iMEI, Vehicle vehicle, Customer customer) {
		this.gpsId = gpsId;
		this.manufactuer = manufactuer;
		this.IMEI = iMEI;
		this.vehicle = vehicle;
		this.customer = customer;
	}
	
	public GPSDevice() {
		
	}

	public long getGpsId() {
		return gpsId;
	}

	public void setGpsId(long gpsId) {
		this.gpsId = gpsId;
	}

	public String getManufactuer() {
		return manufactuer;
	}

	public void setManufactuer(String manufactuer) {
		this.manufactuer = manufactuer;
	}

	public int getIMEI() {
		return IMEI;
	}

	public void setIMEI(int iMEI) {
		IMEI = iMEI;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "GPSDevice [gpsId=" + gpsId + ", manufactuer=" + manufactuer + ", IMEI=" + IMEI + ", vehicle=" + vehicle
				+ ", customer=" + customer + "]";
	}
	
}
