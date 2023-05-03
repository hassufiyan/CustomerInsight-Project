package com.xworkz.customerinsights.dao;




import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.customerinsights.entity.CustomerInsightsEntity;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener;

@Repository
public class CustomerInsightsDaoImpl implements CustomerInsightsDao {

	@Autowired
	EntityManagerFactory entityManager;
	
	
	@Override
	public boolean save(CustomerInsightsEntity entity) {
		if(entityManager!=null) {
			EntityManager eManager=entityManager.createEntityManager();
			try {
			eManager.getTransaction().begin();
			eManager.persist(entity);
			eManager.getTransaction().commit();
		return true;	
		}
			finally {
				eManager.close();		
			}
		}
		return false;
	}


	@Override
	public CustomerInsightsEntity findByEmail(String email) {
//		CustomerInsightsEntity res = null;
		if(entityManager!=null) {
			
			EntityManager eManager=entityManager.createEntityManager();
			try {
			eManager.getTransaction().begin();
			CustomerInsightsEntity res = null;
				try {
			Query	query = eManager.createNamedQuery("findByEmail",CustomerInsightsEntity.class);
				query.setParameter("eid",email);
				query.setMaxResults(1);
	return 	res = (CustomerInsightsEntity) query.getSingleResult();
		
				}
				catch(Exception e) {
					eManager.getTransaction().commit();
				}
			}
		finally {
			eManager.close();		
		}
	}
		return null;
	
			
	}
	
	


	@Override
	public CustomerInsightsEntity findByEmailAndPassword(String email) {
		if (entityManager != null) {
			EntityManager eManager = entityManager.createEntityManager();
			try {
				eManager.getTransaction().begin();
				CustomerInsightsEntity res = null;
				try {
					Query query = eManager.createNamedQuery("findByEmailAndPassowrd", CustomerInsightsEntity.class);
					query.setParameter("eid", email);
					//query.setParameter("pw", password);
					query.setMaxResults(1);
				    res = (CustomerInsightsEntity) query.getSingleResult();
					return res;
				} catch (Exception e) {
					eManager.getTransaction().commit();
					return res;
				}
			} finally {
				eManager.close();
			}
		}
		return null;
	}
//	 public void updateWrongPasswordCount(CustomerInsightsEntity entity {
//	        entity.setWrongPasswordCount(user.getWrongPasswordCount() + 1);
//	        eManager.merge(entity);
//	    }
//}
	

@Override
public int updateByEmailId(String email,int wpc,String status) {
	if (entityManager != null) {
		EntityManager eManager = entityManager.createEntityManager();
		try {
			eManager.getTransaction().begin();
			//CustomerInsightsEntity res = null;
//			try {
				Query query = eManager.createNamedQuery("updateByEmailId");
				query.setParameter("eid", email);
				query.setParameter("wpc", wpc);
				query.setParameter("acs", status);
				query.executeUpdate();
				eManager.getTransaction().commit();
				return 2;
//			} catch (Exception e) {
//				eManager.getTransaction().commit();
//				return 1;
//			}
		} finally {
			eManager.close();
		}
	}
	return 0;
}


@Override
public boolean updateOtpByEmail(int otp, String email) {
	if (entityManager != null) {
		EntityManager eManager = entityManager.createEntityManager();
		try {
			eManager.getTransaction().begin();
			//CustomerInsightsEntity res = null;
				Query query = eManager.createNamedQuery("updateOtpByEmailId");
				query.setParameter("otp",otp);
				query.setParameter("email",email);
				query.executeUpdate();
				eManager.getTransaction().commit();
				return true;
		} 
			finally {
			eManager.close();
		}
	
	}
	return false;
}


@Override
public int getOtpByEmail(String email) {
	System.out.println(email);
	if (entityManager != null) {
		EntityManager eManager = entityManager.createEntityManager();
		try {
			eManager.getTransaction().begin();
			int res=0;
			try {
				Query query = eManager.createNamedQuery("getOtpByEmail");
				query.setParameter("email", email);
				System.out.println(email);
			   res = (int) query.getSingleResult();
			   System.out.println(res);
				return res;
			} catch (NoResultException e) {
				eManager.getTransaction().commit();
				return res;
			}
		} finally {
			eManager.close();
		}
	}
	return 0;
}
//
//@Override
//public int updateAccounStatusByEmail(String status, String email) {
//	if (entityManager != null) {
//		EntityManager eManager = entityManager.createEntityManager();
//		try {
//			eManager.getTransaction().begin();
//			//CustomerInsightsEntity res = null;
//			try {
//				Query query = eManager.createNamedQuery("updateAccountStatusByEmail");
//				query.setParameter("eid", email);
//				query.setParameter("acs", status);
//				query.executeUpdate();
//				return 2;
//			} catch (Exception e) {
//				eManager.getTransaction().commit();
//				return 1;
//			}
//		} finally {
//			eManager.close();
//		}
//				
//	
//}
//	return 0;
//}


@Override
public boolean updatePasswordByEmail(String email, String password) {
if(entityManager!=null) {
	EntityManager eManager =entityManager.createEntityManager();
	try {
		eManager.getTransaction().begin();
	Query	query=eManager.createNamedQuery("updatePassword");
	query.setParameter("eid",email);
	query.setParameter("pwd",password);
		query.executeUpdate();
	eManager.getTransaction().commit();
	return true;	
	}
	finally {
		eManager.close();
	}
}
	return false;
}
}

