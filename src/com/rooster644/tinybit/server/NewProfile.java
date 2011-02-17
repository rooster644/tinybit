package com.rooster644.tinybit.server;
import javax.servlet.http.*;
import java.io.IOException;
import com.googlecode.objectify.*;
import com.rooster644.tinybit.server.data.ProfileData;
import com.google.appengine.api.datastore.*;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
public class NewProfile extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4648286513671125955L;

	public void doGet (HttpServletRequest req, HttpServletResponse resp)
	throws IOException	{
		ObjectifyService.register(ProfileData.class);
		Objectify data = ObjectifyService.begin();
		UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        
        	if (user !=null){
        	Text aboutme = null;
        	ProfileData profile = new ProfileData(aboutme ,user);
        	data.put(profile);
        	resp.getWriter().println("Done");
        	}else{
        		resp.getWriter().println("Is this your profile you are trying to change?");
        	}
        }
	}

