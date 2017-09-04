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

@WebServlet("/Atualiza")
public class Atualiza extends HttpServlet{
	/**
	 * 
	 */
	private static final long serdialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		Notas nota = new Notas();
		String output = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		try {
			JSONObject json = new JSONObject(output);
			Object idJson = json.get("id");
			Object textJson = json.get("text");
			Integer id = Integer.parseInt(idJson.toString());
			String text = textJson.toString();
			nota.setId(id);
			nota.setTexto(text);
			dao.altera(nota);
			dao.close();
//			if(id instanceof Integer){
//			    System.out.println(Inte);
//			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

//		try {
//			dao.altera(nota);
//
//			dao.close();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
