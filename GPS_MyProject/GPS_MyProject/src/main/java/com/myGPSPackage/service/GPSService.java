package com.myGPSPackage.service;

import java.util.ArrayList; 
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myGPSPackage.models.Customer;
import com.myGPSPackage.models.GPSDevice;
import com.myGPSPackage.models.Vehicle;
import com.myGPSPackage.repository.GPSRepository;


@Service
public class GPSService implements GPSRepository {
	@Autowired
	private  EntityManagerFactory emf;
	
	//get EntityManager
	private EntityManager getEm() {
		return emf.createEntityManager();
	}

	//user should carry some information from userForm
		public void createNewCustomer(String name, int regNumberCAC) {
			//boolean userCreated = false;
				try{
					//Customer customer = new Customer();									
					EntityManager em = getEm();				
					em.getTransaction().begin();
											//TypedQuery<Customer> hsq = em.createQuery("Insert into Customer values", Customer.class);										//TypedQuery<Customer> hsq = em.createQuery("From  SystemUser", Customer.class); //From  SystemUser s where s.status is Not Null"
					Customer customer = new Customer();
					customer.setCid(customer.getCid());
					customer.setName(name);
					customer.setRegNumberCAC(regNumberCAC);
					customer.setGpsDevice(customer.getGpsDevice());
					customer.setVehicle(customer.getVehicle());
					em.persist(customer);
					em.flush();
					
					em.getTransaction().commit();
					//userCreated = true;
					
				} catch(EntityExistsException e) {
					e.printStackTrace();
				}
			}
		
		public void createNewGPSDevice(String manufacturer, int iMEI) {
			//boolean userCreated = false;
				try{
					//Customer customer = new Customer();									
					EntityManager em = getEm();				
					em.getTransaction().begin();
											//TypedQuery<Customer> hsq = em.createQuery("Insert into Customer values", Customer.class);										//TypedQuery<Customer> hsq = em.createQuery("From  SystemUser", Customer.class); //From  SystemUser s where s.status is Not Null"
					GPSDevice gps = new GPSDevice();
					
					Customer c = new Customer();
					Vehicle v = new Vehicle();
					
					v.setVid(v.getVid());
					v.setName("VehicleName");
					v.setCustomer(c);
					v.setRegNumber(123654);
					v.setGpsDevice(gps);
					
					c.setCid(c.getCid());
					c.setGpsDevice(gps);
					c.setName("CustomerName");
					c.setVehicle(v);
					c.setRegNumberCAC(9874);
					
					gps.setCustomer(c);
					gps.setVehicle(v);
					gps.setIMEI(iMEI);
					gps.setManufactuer(manufacturer);
					em.persist(gps);
					em.flush();
					
					em.getTransaction().commit();
					//userCreated = true;
					
				} catch(EntityExistsException e) {
					e.printStackTrace();
				}
			}
	
		//get all users
		
	public List<Customer> getAllCustomer(){
		
		EntityManager em = getEm();			
		em.getTransaction().begin();
		List<Customer> customers = new ArrayList<>();
		TypedQuery<Customer> hql = em.createQuery("From Customer", Customer.class);
		customers = hql.getResultList();
		
		em.getTransaction().commit();
		
		return customers;
	}
}
