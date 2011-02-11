package com.rooster644.tinybit.server.data;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.google.appengine.api.users.User;

public class UserLoginData {
	@Id public Long id;
	String loggedin;
	User uname;
	@Transient String doNotPersist;
	
	private UserLoginData() {}
	
	public UserLoginData (String loggedin, User uname)
	{
		this.loggedin = loggedin;
		this.uname = uname;
	}
}