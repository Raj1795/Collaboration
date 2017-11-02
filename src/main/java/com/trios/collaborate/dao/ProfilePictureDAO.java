package com.trios.collaborate.dao;

import com.trios.collaborate.model.ProfilePicture;

public interface ProfilePictureDAO {
	
	void save(ProfilePicture profilePicture);
	ProfilePicture getProfilePic(String userId);
}
