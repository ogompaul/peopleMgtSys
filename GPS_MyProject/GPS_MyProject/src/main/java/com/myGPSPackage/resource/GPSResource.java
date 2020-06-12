package com.myGPSPackage.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myGPSPackage.models.Customer;
import com.myGPSPackage.repository.GPSRepository;

@RestController
public class GPSResource {
	
	@Autowired
	private GPSRepository repo;
	
	@GetMapping("/home")
	public String homeh() {
		return "Welcome GPDDEVICE";
	}
	
	@GetMapping("/savecustomer/{name}/{regNumberCAC}")
	public String savec(@PathVariable String name, @PathVariable int regNumberCAC) {
		repo.createNewCustomer(name, regNumberCAC);
		return "Customer Added to DB";
	}
	
	@GetMapping("/savegps/{manufacturer}/{iMEI}")
	public String saveg(@PathVariable String manufacturer, @PathVariable int iMEI) {
		repo.createNewGPSDevice(manufacturer, iMEI);
		return "Device added to DB";
	}
	
	@GetMapping(value="/show", produces="application/json")
	public List<Customer> showh() {
		List<Customer> list = new ArrayList<>();
		list = repo.getAllCustomer();
		return list;
	}
}
