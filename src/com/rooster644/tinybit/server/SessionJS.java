package com.rooster644.tinybit.server;
import java.io.IOException;
import javax.jdo.PersistenceManager;
import javax.servlet.http.*;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.rooster644.tinybit.server.PMF;
import com.rooster644.tinybit.server.data.UserData;
public class SessionJS extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws IOException {
		UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        if (user != null) {
        String loggedin = "1";
        UserData udata = new UserData(user, loggedin);
        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
        	pm.makePersistent(udata);
        } finally {
        	pm.close();
        }
        resp.setContentType("text/javascript");
        resp.getWriter().println("var loggedin = \"" + loggedin + "\"");
        resp.getWriter().println("var user = \"" + user + "\"");
        }else{
        	resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
        }
}
}