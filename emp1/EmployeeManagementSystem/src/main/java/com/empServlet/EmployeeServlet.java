package com.empServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet {
	private static String url="jdbc:postgresql://localhost:5432/EmployeeManagementSystem?user=postgres&password=123";
	//private static String url = "jdbc:postgresql://localhost:5432/emp";
	//private static String user = "postgres";
	//private static String password = "123";

	private static Connection conn;

	static {
	    try {
	        // Load the PostgreSQL driver
	        Class.forName("org.postgresql.Driver");
	        
	        // Attempt to establish a connection
	        conn = DriverManager.getConnection(url);
	        
	        if (conn == null) {
	            System.err.println("Failed to establish a connection to the database.");
	        } else {
	            System.out.println("Database connection established successfully.");
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if the connection is null
        if (conn == null) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database connection failed.");
            return;
        }

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int salary = Integer.parseInt(request.getParameter("salary"));

        String sql = "INSERT INTO employee (id, name, age, salary) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.setInt(4, salary);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error while inserting employee data.");
            return;
        }

        // Redirect back to Home.html
        response.sendRedirect("Home.html");
    }
}