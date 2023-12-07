package com.javacourse.project.hibernateAndJpa.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.project.hibernateAndJpa.DataAccess.ICityDal;
import com.javacourse.project.hibernateAndJpa.Entities.City;

@Service
public class CityManager implements ICityService{
	
	private ICityDal citydal;
	
	
	@Autowired // IcityDal a uygun bir şey varsa onu ver(şu an için sadece hibernate var)
	public CityManager(ICityDal citydal) {
		this.citydal = citydal;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		// TODO Auto-generated method stub
		return this.citydal.getAll();
	}

	@Override
	@Transactional
	public void add(City city) {
		this.citydal.add(city);
	}

	@Override
	@Transactional
	public void update(City city) {
		this.citydal.update(city);

		
	}

	@Override
	@Transactional
	public void delete(City city) {
		this.citydal.delete(city);
		
	}

	@Override
	@Transactional
	public City getById(int id) {

		return this.citydal.getById(id);
	}

}
