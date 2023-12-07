package com.javacourse.project.hibernateAndJpa.DataAccess;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.project.hibernateAndJpa.Entities.City;

import jakarta.persistence.EntityManager;


@Repository
public class HibernateCityDal implements ICityDal{
	//JPA standartlarının olduğu class
	private EntityManager entitiyManager;
	
	
	@Autowired //sessionları otomatik enjekte edecek (bu kod için hibernate enjeksiyonları gelecek)
	public HibernateCityDal(EntityManager entitiyManager) {
		this.entitiyManager = entitiyManager;
	}
	
	
	
	// AOP -Aspect Oriented Programming
	@Override
	@Transactional //(session açma kapama olayını arka planda otomatik yapıyor)
	public List<City> getAll() {
			
						// bana bir session nesnesi ver (for hibernate)
		Session session = entitiyManager.unwrap(Session.class);
		
		List<City> cities = session.createQuery("from City", City.class).getResultList();
		
		return cities;
	}

	@Override
	@Transactional
	public void add(City city) {
		Session session = entitiyManager.unwrap(Session.class);
		session.save(city);
	}

	@Override
	@Transactional
	public void update(City city) {
		Session session = entitiyManager.unwrap(Session.class);
		session.update(city);		
	}

	@Override
	@Transactional
	public void delete(City city) {
		Session session = entitiyManager.unwrap(Session.class);
		City cityToDelete = session.get(City.class, city.getId());
		session.delete(cityToDelete);		
	}

	@Override
	public City getById(int id) {
		Session session = entitiyManager.unwrap(Session.class);

		City city = session.get(City.class, id);
		return city;
	}
	

}
