package com.rooster644.tinybit.server.data;
import javax.persistence.Id;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.api.users.User;
public class IDData {
	@Id Long id;
	Text about;
	User uname;
	
	private IDData() {}
	
	public IDData (Text about, User uname)
	{
		this.about = about;
		this.uname = uname;
	}
}
