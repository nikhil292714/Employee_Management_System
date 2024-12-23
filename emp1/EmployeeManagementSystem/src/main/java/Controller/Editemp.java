package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Employe;
import Service.EmpService;

/**
 * Servlet implementation class Editemp
 */
//@WebServlet("/Editemp")
public class Editemp extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		
		String salaray=request.getParameter("salary");
		
		int ids=Integer.parseInt(id);
		int agess=Integer.parseInt(age);
		int salarys=Integer.parseInt(salaray);
		
		Employe e=new Employe(ids, name, agess, salarys);
		
		
		EmpService empService=new EmpService();
		int res=empService.update(e);
		if (res!=0) {
			RequestDispatcher rsdp=request.getRequestDispatcher("Home.html");
			
			rsdp.include(request, response);
		}
		
	}

}
