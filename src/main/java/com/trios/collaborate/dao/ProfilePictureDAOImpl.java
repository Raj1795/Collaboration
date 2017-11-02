package com.trios.collaborate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trios.collaborate.model.ProfilePicture;

@Repository("profilePictureDAO")
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public ProfilePictureDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void save(ProfilePicture profilePicture) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(profilePicture);
		
	}


	public ProfilePicture getProfilePic(String userId) {
Session session=sessionFactory.getCurrentSession();
		
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class, userId);
		return profilePicture;
		
	}
	
}
