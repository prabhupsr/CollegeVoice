package com.college.voiceapp.configuration;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.college.voiceapp.entites.UserDetails;
@Configuration
public class TstMan {
	
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DBConfig.class);
		TstDao tstDao=((TstDao) context.getBean("TstDao"));
		
		for(int i=1;i<11;i++){
			tstDao.saveData(new UserDetails("pr"+i, i));
		}
		List persons = ((TstDao) context.getBean("TstDao"))
				.fetchPersons();
		System.out.println(persons);
	}*/

}
