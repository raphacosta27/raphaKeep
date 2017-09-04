package edu.insper.rapha;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/lista")
public class Lista extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			DAO dao = new DAO();
			List<Notas> notas = dao.getLista();
			PrintWriter out = response.getWriter();
			out.println("<html><body><table border='1'>");
			out.println("<tr><td>ID</td><td>Texto</td>");
			for (Notas nota: notas) {
				out.println("<tr><td>" + nota.getId() + "</td>");
				out.println("<td>" + nota.getTexto() + "</td>");
			}
			out.println("</table></body></html>");

			dao.close();

	}
	
}
