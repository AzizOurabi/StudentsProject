

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
 * Servlet implementation class UpdateServlet2
 */
@WebServlet("/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		
		String studentId = request.getParameter("id");
		int id = Integer.parseInt(studentId);
		String name = request.getParameter("name");
		String password = request.getParameter("pswd");
		String email = request.getParameter("email");
		String country = request.getParameter("pays");
		
		Student student = new Student();
		
		student.setId(id);
		student.setName(name);
		student.setPassword(password);
		student.setEmail(email);
		student.setCountry(country);
		
		int num = StudentSQL.update(student);
		if(num > 0) {
			response.sendRedirect("ViewServlet");
		}
		else {
			printWriter.println("<h2>sorry not updated</h2>");
		}
		
		
		
		
	}

}
