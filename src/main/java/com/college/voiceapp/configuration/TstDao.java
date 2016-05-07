package com.college.voiceapp.configuration;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.college.voiceapp.entites.UserDetails;

@Component
public class TstDao {
	@Autowired
	SessionFactory sessionFactory;
 
	@Transactional
	public List fetchPersons() {
		return sessionFactory.getCurrentSession().createQuery("from UserDetails")
				.list();
	}
	
	@Transactional
	public int saveData(UserDetails userDetails){
		
		 return (Integer) sessionFactory.getCurrentSession().save(userDetails);
	}
	
	@Transactional
	public UserDetails getUserDetails(String userName){
		 return  ((List<UserDetails>) sessionFactory.getCurrentSession().createQuery("from UserDetails where userName like '"+userName+"'").list()).get(0);
	}

}
