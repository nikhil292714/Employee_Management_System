package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Employe;
import Service.EmpService;

public class DisplayAll extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Set response content type
	    response.setContentType("text/html");

	    // Fetch data from EmpService
	    EmpService empService = new EmpService();
	    List<Employe> emps = empService.fetchAll();

	    // Prepare the response writer
	    PrintWriter pr = response.getWriter();

	    // Start of the HTML structure
	    pr.print("<!DOCTYPE html>");
	    pr.print("<html lang=\"en\">");
	    pr.print("<head>");
	    pr.print("    <meta charset=\"UTF-8\">");
	    pr.print("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
	    pr.print("    <title>User Table</title>");
	    pr.print("    <style>");
	    pr.print("        body { font-family: Arial, sans-serif; background-color: #f4f4f4; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }");
	    pr.print("        .container { background-color: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
	    pr.print("        table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
	    pr.print("        table, th, td { border: 1px solid #ddd; }");
	    pr.print("        th, td { padding: 10px; text-align: left; }");
	    pr.print("        th { background-color: #f2f2f2; }");
	    pr.print("        .action-link { margin: 5px; padding: 5px 10px; font-size: 14px; cursor: pointer; text-decoration: none; border-radius: 5px; color: white; transition: background-color 0.3s; }");
	    pr.print("        .link-edit { background-color: #28a745; }");
	    pr.print("        .link-edit:hover { background-color: #218838; }");
	    pr.print("        .link-delete { background-color: #dc3545; }");
	    pr.print("        .link-delete:hover { background-color: #c82333; }");
	    pr.print("    </style>");
	    pr.print("</head>");
	    pr.print("<body>");
	    pr.print("    <div class=\"container\">");
	    pr.print("        <h1>User Table</h1>");
	    pr.print("        <table>");
	    pr.print("            <thead>");
	    pr.print("                <tr>");
	    pr.print("                    <th>ID</th>");
	    pr.print("                    <th>Name</th>");
	    pr.print("                    <th>Age</th>");
	    pr.print("                    <th>Salary</th>");
	    pr.print("                    <th>Actions</th>");
	    pr.print("                </tr>");
	    pr.print("            </thead>");
	    pr.print("            <tbody>");

	    // Loop through the employees and create rows
	    for (Employe employe : emps) {
	        int id = employe.getId();
	        String name = employe.getName();
	        int age = employe.getAge();
	        int salary = employe.getSalary();

	        pr.print("<tr>");
	        pr.print("    <td>" + id + "</td>");
	        pr.print("    <td>" + name + "</td>");
	        pr.print("    <td>" + age + "</td>");
	        pr.print("    <td>" + salary + "</td>");
	        pr.print("    <td>");
	        pr.print("        <a class='action-link link-edit' href='Edit.html?id=" + id + "'>Edit</a>");
	        pr.print("        <a class='action-link link-delete' href='Delete.html?id=" + id + "'>Delete</a>");
	        pr.print("    </td>");
	        pr.print("</tr>");
	    }

	    // Close the table and HTML structure
	    pr.print("            </tbody>");
	    pr.print("        </table>");
	    pr.print("    </div>");
	    pr.print("</body>");
	    pr.print("</html>");

	    // Close the PrintWriter
	    pr.close();
	    
	    

	}

}