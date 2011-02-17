package com.rooster644.tinybit.server;
import java.io.IOException;
import javax.servlet.http.*;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.*;
import com.rooster644.tinybit.server.data.UserLoginData;
public class SessionJS extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2202355476539789366L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws IOException {
		UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        if (user != null) {
        String loggedin = "1";
        ObjectifyService.register(UserLoginData.class);
        Objectify data = ObjectifyService.begin();
        UserLoginData udata = new UserLoginData(loggedin,user);
        data.put(udata);
        assert udata.id != null;
        resp.setContentType("text/javascript");
        resp.getWriter().println("var loggedin = \"" + loggedin + "\"");
        resp.getWriter().println("var user = \"" + user + "\"");
        }else{
        	resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
        }
}
}