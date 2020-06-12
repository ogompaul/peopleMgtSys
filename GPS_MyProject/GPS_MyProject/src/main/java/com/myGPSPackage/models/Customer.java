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
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cid;
	
	@Column
	private String name;
	
	@Column
	private int regNumberCAC;
		
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
	private Vehicle vehicle;
		
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="gpsDevice_gpsId")
	private GPSDevice gpsDevice;

	public Customer(long cid, String name, int regNumberCAC) {
		this.vehicle = new Vehicle();
		this.gpsDevice = new GPSDevice();		
			this.cid = cid;
			this.name = name;
			this.regNumberCAC = regNumberCAC;
	}
	
	
	public Customer() {

	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRegNumberCAC() {
		return regNumberCAC;
	}

	public void setRegNumberCAC(int regNumberCAC) {
		this.regNumberCAC = regNumberCAC;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public GPSDevice getGpsDevice() {
		return gpsDevice;
	}

	public void setGpsDevice(GPSDevice gpsDevice) {
		this.gpsDevice = gpsDevice;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", regNumberCAC=" + regNumberCAC + ", vehicle=" + vehicle
				+ ", gpsDevice=" + gpsDevice + "]";
	}
	
}
