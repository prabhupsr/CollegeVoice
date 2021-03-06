package com.college.voiceapp.configuration;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.college.voiceapp.entites.MessageLikes;
import com.college.voiceapp.entites.Messages;
import com.college.voiceapp.entites.UserDetails;
import com.college.voiceapp.pojo.MessageWithLike;

@Component
public class TstDao {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List fetchPersons() {
		return sessionFactory.getCurrentSession().createQuery("from UserDetails").list();
	}
	
	@Transactional
	public List<Messages> fetchAllMessages() {
		return (List<Messages>)sessionFactory.getCurrentSession().createQuery("from Messages").list();
	}
	
	@Transactional
	public List<MessageWithLike> fetchAllMessagesWithLike(int userID) {
		Query query = sessionFactory.getCurrentSession().createQuery("select messageId as messageId,message as message,messageUserId as messageUserId,(select msglke.userId from MessageLikes msglke where userId="+userID +" and msglke.messageId=msg.messageId) as likedUserId from Messages msg");
		
		query.setResultTransformer(Transformers.aliasToBean(MessageWithLike.class));
		return (List<MessageWithLike>)query.list();
	}

	@Transactional
	public int saveData(UserDetails userDetails) {

		return (Integer) sessionFactory.getCurrentSession().save(userDetails);
	}
	
	@Transactional
	public boolean postMessage(Messages messages){		
		sessionFactory.getCurrentSession().save(messages);
		return true;		
	}
	
	@Transactional
	public boolean postMessageLikes(MessageLikes messagesLikes){		
		sessionFactory.getCurrentSession().save(messagesLikes);
		return true;		
	}

	@Transactional
	public UserDetails getUserDetails(String userName, String password) {
		@SuppressWarnings("unchecked")
		List<UserDetails> userDetail = sessionFactory.getCurrentSession()
				.createQuery(
						"from UserDetails where userName like '" + userName + "' and password like '" + password + "'")
				.list();
		if (userDetail != null && !userDetail.isEmpty())
			return userDetail.get(0);

		return null;
	}
}
