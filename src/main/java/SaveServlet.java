

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import azizourabi.Student;
import azizourabi.StudentSQL;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub
	 * response.getWriter().append("Served at: ").append(request.getContextPath());
	 * }
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printwriter = response.getWriter();
		
		String name = request.getParameter("name");
		String password = request.getParameter("pswd");
		String email = request.getParameter("email");
		String country = request.getParameter("pays");
		
		Student student = new Student();
		student.setName(name);
		student.setPassword(password);
		student.setEmail(email);
		student.setCountry(country);
		
		int num = StudentSQL.save(student);
		
		if(num > 0) 
		{
			printwriter.println("<h2>data saved successfully</h2>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else {
			printwriter.println("<h2>data not saved</h2>");
		}
		
	}

}
