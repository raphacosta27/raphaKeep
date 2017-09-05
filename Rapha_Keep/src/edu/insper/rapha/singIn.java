package edu.insper.rapha;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class singIn
 */
@WebServlet("/singIn")
public class singIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public singIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		List<Users> users = dao.getUsers();
		String output = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		try {
			JSONObject json = new JSONObject(output);
			Object userJson = json.get("user");
			Object passJson = json.get("pass");
			Users user = new Users();
			user.setUser(userJson.toString());
			user.setPassword(passJson.toString());
			dao.singIn(user);
			dao.close();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
