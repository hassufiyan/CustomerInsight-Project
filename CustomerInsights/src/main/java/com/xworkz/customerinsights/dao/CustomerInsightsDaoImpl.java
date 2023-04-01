package com.xworkz.customerinsights.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.customerinsights.entity.CustomerInsightsEntity;

@Repository
public class CustomerInsightsDaoImpl implements CustomerInsightsDao {

	@Autowired
	EntityManagerFactory entityManager;
	
	
	@Override
	public String save(CustomerInsightsEntity entity) {
		if(entityManager!=null) {
			EntityManager eManager=entityManager.createEntityManager();
			try {
			eManager.getTransaction().begin();
			eManager.persist(entity);
			eManager.getTransaction().commit();
		return "SignUp";	
		}
			finally {
				eManager.close();		
			}
		}
		return null;
	}
	}

