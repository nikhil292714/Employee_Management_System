package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.EmpService;

/**
 * Servlet implementation class DeleteEmp
 */
//@WebServlet("/DeleteEmp")
public class DeleteEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids=request.getParameter("id");
		  int id=Integer.parseInt(ids);	
		  
		  EmpService empService=new EmpService();
		  int res=empService.delete(id);
		  if (res!=0) {
			RequestDispatcher rsdp=request.getRequestDispatcher("Home.html");
			rsdp.include(request, response);
		}
	}



}
