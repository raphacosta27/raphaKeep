package edu.insper.rapha;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cria")
public class Cria extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("texto: <input type='text' name='texto'><br>");;
		out.println("</form>");
		out.println("<body><html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		Notas nota = new Notas();
		
		nota.setTexto(request.getParameter("texto"));
		
		dao.adiciona(nota);
	
		dao.close();

	}
}
