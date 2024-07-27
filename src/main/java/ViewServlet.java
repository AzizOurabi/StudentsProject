

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import azizourabi.Student;
import azizourabi.StudentSQL;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();

		printWriter.print("<head>");
        printWriter.print("<meta charset='UTF-8'>");
        printWriter.print("<title>View Servlet</title>");
        printWriter.print("<link href = 'css/bootstrap.css' rel = 'stylesheet'>");
        printWriter.print("</head>");
        
        printWriter.print("<body>");
        printWriter.println("<a href = 'index.html' class = 'btn btn-info' role = 'button'>Add Student");
        
        printWriter.println("<h1>Student Table</h1>");
        
        List<Student> list = StudentSQL.getAllStudents();
        
        printWriter.print("<table border='1' width='100%'");
        printWriter.println("<tr><th>Id</th><th>Name</th>"
        		+ "<th>Password</th><th>Email</th>"
        		+"<th>Country</th> <th>Edit</th> <th>Delete</th></tr>");
        for (Student student : list) {
        	printWriter.print("<tr><td>" + student.getId() + "</td>"
        	+"<td>"+ student.getName() + "</td>"+"<td>"+ student.getPassword() + "</td>"+"<td>" + student.getEmail() + "</td>"
            +"<td>" + student.getCountry() + "</td>"+"<td><a href='UpdateServlet?id='"+ student.getId() + ">edit</a></td>"
            +"</td>"+"<td><a href='DeleteServlet?id='"+ student.getId() + ">delete</a></td></tr>");
		}
        printWriter.print("</table>");
        printWriter.print("</body>");
        
	}


}
