package com.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		// unit of work
		Session session = factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
			
			// INSERT
			/*
			 * City newCity = new City(); newCity.setName("Palermo");
			 * newCity.setCountryCode("ITA"); newCity.setPopulation(10);
			 * newCity.setDistrict("DomStudenta");
			 * 
			 * session.save(newCity);
			 */
			
			//Update
			/*
			 * City newCity = session.get(City.class,4080); //4080 = id
			 * newCity.setCountryCode("TUR");
			 * 
			 * session.save(newCity);
			 */
			
			//Delete
			/*
			 * City newCity = session.get(City.class,4080); //4080 = id
			 * newCity.delete(newCity);
			 * 
			 */
			
			                                       //HQL --> hibernate query language
			List<City> cities = session.createQuery("from City c where c.countryCode = 'TUR' OR c.countryCode = 'ITA' ").getResultList();
			
			for(City city : cities) {
				System.out.println(city.getName());
			}
			
			session.getTransaction().commit();
			
		} finally {
			
			factory.close();
		}
		
		
	}

}
