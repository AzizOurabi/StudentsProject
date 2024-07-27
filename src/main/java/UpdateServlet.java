

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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1>update student info</h1>");
		String studentId = request.getParameter("id");
		
		int id = Integer.parseInt(studentId);
		Student student = StudentSQL.getStudentById(id);
		
		printWriter.print("<head>");
        printWriter.print("<meta charset='UTF-8'>");
        printWriter.print("<title>Formulaire d'inscription</title>");
        printWriter.print("<link href = 'css/bootstrap.css' rel = 'stylesheet'>");
        printWriter.print("</head>");
        printWriter.print("<body>");
        printWriter.print("<h2>Formulaire d'inscription</h2>");
        printWriter.print("<form action='register' method='post'>");
        printWriter.print("<table>");
        printWriter.print("<tr><td><label for='name'>Nom:</label></td>");
        printWriter.print("<td><input type='text' id='name' name='name' value='" + student.getName() + "'></td></tr>");
        printWriter.print("<tr><td><label for='password'>Mot de passe:</label></td>");
        printWriter.print("<td><input type='password' id='password' name='password' value='" + student.getPassword() + "'></td></tr>");
        printWriter.print("<tr><td><label for='email'>Email:</label></td>");
        printWriter.print("<td><input type='email' id='email' name='email' value='" + student.getEmail() + "'></td></tr>");
        printWriter.print("<tr><td><label for='country'>Pays:</label></td>");
        printWriter.print("<td><input type='text' id='country' name='country' value='" + student.getCountry() + "'></td></tr>");
        printWriter.print("<tr><td colspan='2' style='text-align:center;'>");
        printWriter.print("<input type='submit' value='S'inscrire'></td></tr>");
        printWriter.print("</table>");
        printWriter.print("</form>");
        printWriter.print("</body>");	
	        
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
