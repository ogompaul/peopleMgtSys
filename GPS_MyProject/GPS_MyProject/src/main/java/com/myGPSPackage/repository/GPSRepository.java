package com.myGPSPackage.repository;

import java.util.List; 
import org.springframework.stereotype.Repository;
import com.myGPSPackage.models.Customer;

@Repository
public interface GPSRepository {
	
	/*@Modifying
	@Query(
			value = 
		    	"insert into Customer (name, regNumberCAC) values (:name, :regNumberCAC)",
		  nativeQuery = true
			)
	public void createNewCustomer(@Param("name") String name, @Param("regNumberCAC") int regNumberCAC);
	
	@Query("FROM Customer where cid IS NOT NULL")
	public List<Customer> getAllCustomer(); */
	
	public void createNewCustomer(String name, int regNumberCAC);
	public List<Customer> getAllCustomer();
	public void createNewGPSDevice(String manufacturer, int iMEI);
}
