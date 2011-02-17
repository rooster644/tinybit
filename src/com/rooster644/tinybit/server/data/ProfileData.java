package com.rooster644.tinybit.server.data;
import javax.persistence.Id;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.api.users.User;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Parent;
public class ProfileData {
	@Id Long id;
	@Parent Key<UserLoginData> user;
	public Text about;
	User uname;
	
	
	private ProfileData() {}
	
	public ProfileData (Text about, User uname)
	{
		this.about = about;
		this.uname = uname;
		
		
	}
}
