package com.rooster644.tinybit.server;
import java.io.IOException;
import javax.servlet.http.*;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.rooster644.tinybit.server.data.ProfileData;
import org.itemscript.core.JsonSystem;
import org.itemscript.core.values.JsonObject;
import org.itemscript.standard.StandardConfig;
public class MyProfile extends HttpServlet {
	
	private static final long serialVersionUID = 3086904132128921257L;

	
	@SuppressWarnings("unused")
	public void doGet (HttpServletRequest req, HttpServletResponse resp)
	throws IOException	{
		ObjectifyService.register(ProfileData.class);
		Objectify data = ObjectifyService.begin();
		String uname = req.getParameter("uname");
		ProfileData Profiledata = data.query(ProfileData.class).filter("uname", uname).get();
		String output = Profiledata.about.toString();
		if (Profiledata !=null) {
		JsonSystem jsonsystem = StandardConfig.createSystem();
		JsonObject jsonobj = jsonsystem.createObject();
		jsonobj.put("status", "200");
		jsonobj.put("uname", uname);
		jsonobj.put("text", output);
		String finishedjson = jsonobj.toString();
		resp.getWriter().println(finishedjson);
	}else{
		JsonSystem jsonsystem = StandardConfig.createSystem();
		JsonObject jsonobj = jsonsystem.createObject();
		jsonobj.put("status", "failed");
		String finishedjson = jsonobj.toString();
		resp.getWriter().println(finishedjson);
	}
	}
}
