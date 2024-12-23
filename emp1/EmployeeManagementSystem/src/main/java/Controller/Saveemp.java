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
 * Servlet implementation class Saveemp
 */
//@WebServlet("/Saveemp")
public class Saveemp extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		  String name= request.getParameter("name");
		  String age= request.getParameter("age");
		   String salary=request.getParameter("salary");
		   
		   int ids=Integer.parseInt(id);
		   int salarys=Integer.parseInt(salary);
		   int ages=Integer.parseInt(age);
		   
		Employe e=new Employe();
		e.setId(ids);
		e.setName(name);
		e.setAge(ages);
		e.setSalary(salarys);
		EmpService empService=new EmpService();
		int res=empService.save(e);
		if (res!=0) {
			RequestDispatcher rs=request.getRequestDispatcher("Home.html");
			rs.include(request, response);
			   
		}
		else
		{
			RequestDispatcher rs=request.getRequestDispatcher("Home.html");
			rs.include(request, response);
			   
		}
	}


}
