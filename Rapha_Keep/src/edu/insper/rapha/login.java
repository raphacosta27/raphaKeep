package edu.insper.rapha;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import org.json.*;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setContentType("application/json");
		DAO dao = new DAO();
		List<Users> users = dao.getUsers();
		String output = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		JSONObject responseJson = new JSONObject();
		try {
			JSONObject json = new JSONObject(output);
			System.out.println(json);
			Object userJson = json.get("user");
			Object passJson = json.get("pass");
			for(int i=0;i<users.size();i++){
				Users user = users.get(i);
				if(user.getUser().equals(userJson)){
					if(user.getPassword().equals(passJson)){
						System.out.println("Cadastrado");
						responseJson.put("login", "confirmed");
						responseJson.put("user", userJson.toString());						
						System.out.println(responseJson);
//						response.getWriter().println(responseJson);
						break;
//						response.sendRedirect(request.getContextPath() + "/index.jsp");
					}
					}
				else{
					continue;

				}
			}
			if (responseJson.length()>0){
				response.getWriter().println(responseJson);
			}
			else {
				responseJson.put("login", "unconfirmed");
				response.getWriter().println(responseJson);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
