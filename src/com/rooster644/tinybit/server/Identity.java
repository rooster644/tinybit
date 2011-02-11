package com.rooster644.tinybit.server;
import javax.servlet.http.*;
import java.io.IOException;
import com.googlecode.objectify.*;
import com.rooster644.tinybit.server.data.IDData;
public class Identity extends HttpServlet {
	public void doPost (HttpServletRequest req, HttpServletResponse resp)
	throws IOException	{
		ObjectifyService.register(IDData.class);
		
	}

}
