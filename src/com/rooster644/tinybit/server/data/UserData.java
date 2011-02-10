package com.rooster644.tinybit.server.data;
//Import User and Key App Engine Datastore data types
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public class UserData {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private User user;	
	@Persistent
	private String loggedin;
	public UserData(User user, String loggedin){
		this.user = user;
		this.loggedin = loggedin;
	}
	public Key getKey() {
		return key;
	}
	public User getUser() {
		return user;
	}
	public String getLoggedIn() {
		return loggedin;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setLoggedIn(String loggedin) {
		this.loggedin = loggedin;
	}
}