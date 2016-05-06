package com.college.voiceapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.college.voiceapp.entites.UserDetails;
import com.college.voiceapp.utils.HibernateUtil;

import oracle.jdbc.driver.OracleDriver;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/login/", method = RequestMethod.POST)
	public String loginPage(Locale locale, Model model,@RequestParam("userName") String userName,@RequestParam("password") String password) {
		
		System.out.println("userName"+userName);
		System.out.println(password);
		/*Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		session.save(new UserDetails("prabhu", 1));
		session.getTransaction().commit();
		System.out.println("done");*/

		
		
		return "login";
	}/*
	public static void main(String[] args){
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		session.save(new UserDetails("prabhu", 1));
		session.getTransaction().commit();
		System.out.println("done");
	}*/
	
	@RequestMapping(value = "/login1/", method = RequestMethod.POST)
	@ResponseBody
	public String loginPage1(Locale locale, Model model,@RequestParam("userName") String userName,@RequestParam("password") String password) {
		
		System.out.println(userName);
		System.out.println(password);
		/*Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		session.save(new UserDetails("prabhu", 1));
		session.getTransaction().commit();
		System.out.println("done");*/

		
		
		return "Successfully Logged in...";
	}
	

}
