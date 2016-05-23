package com.college.voiceapp;

import java.text.DateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.college.voiceapp.configuration.ReferenceData;
import com.college.voiceapp.configuration.TstDao;
import com.college.voiceapp.entites.MessageLikes;
import com.college.voiceapp.entites.Messages;
import com.college.voiceapp.entites.UserDetails;
import com.college.voiceapp.utils.HibernateUtil;
import com.google.gson.Gson;




/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("userId")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	TstDao tstDao;
	
	
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
		System.out.println(tstDao.fetchPersons());

		return "login";
	}
	
	@RequestMapping(value = "/login/", method = RequestMethod.GET)
	public String loginPage(Locale locale, Model model,HttpSession httpSesson,@RequestParam("userName") String userName,@RequestParam("password") String password) {
		//tstDao.saveData(new UserDetails("prabhu", "prr",1,new Date()));
		
		
		UserDetails userDetails = tstDao.getUserDetails(userName,password);
		httpSesson.setAttribute(ReferenceData.userName, (userDetails == null)?null:userDetails.getUserName());
		httpSesson.setAttribute(ReferenceData.userID, (userDetails == null)?null:userDetails.getUserId());
		model.addAttribute("reloadID", "true");
		String  userType=(userDetails == null)?"login":"home"/*ReferenceData.userTypeMappng[userDetails.getUserType()]*/;
		
		return userType;
	}
	
	@RequestMapping(value = "/postmessage/", method = RequestMethod.GET)
	@ResponseBody
	public String loginPage1( Model model,HttpSession httpSesson,@RequestParam("message") String message) {
		
		
		tstDao.postMessage(new Messages(message,"1",new Date(),new Date())) ;
		
		List<Messages> fetchAllMessages = tstDao.fetchAllMessages();
		Collections.sort(fetchAllMessages, new Comparator<Messages>() {

			@Override
			public int compare(Messages o1, Messages o2) {
				// TODO Auto-generated method stub
				return o2.getCreatedDate().compareTo(o1.getCreatedDate());
			}
		});
		System.out.println(fetchAllMessages);
		// create a new Gson instance
		 Gson gson = new Gson();
		 // convert your list to json
		 String jsonCartList = gson.toJson(fetchAllMessages);
		 System.out.println("from sesson"+httpSesson.getAttribute(ReferenceData.userID));
		
		return jsonCartList;
	}
	
	@RequestMapping(value = "/updatelike/", method = RequestMethod.GET)
	@ResponseBody
	public String updateMsgLike(Locale locale, Model model,HttpSession httpSesson,@RequestParam("messageID") int messageID) {
		new MessageLikes(Integer.parseInt( httpSesson.getAttribute(ReferenceData.userID).toString()),messageID,new Date()); 
		System.out.println("messageID - "+messageID);
		return "Done";
	}

}
