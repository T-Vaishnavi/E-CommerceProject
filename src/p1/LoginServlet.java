package p1;

import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String str1=request.getParameter("id1");
		String str2=request.getParameter("txtpass1");
	    
		if(str1.equals("admin@gmail.com")&&(str2.equals("admin@123")))
		{
			out.println("Successfully logged by admin");
			RequestDispatcher rd=request.getRequestDispatcher("ProductAdmin.jsp");
			rd.include(request, response);
		}
		else if(str1.equals("user")&&(str2.equals("123")))
		{
			out.println("Successfully logged by user");
			RequestDispatcher rd=request.getRequestDispatcher("ProductImages.jsp");
			rd.include(request, response);
		}
		else
		{
			out.println("Check Credentials");
			RequestDispatcher rd=request.getRequestDispatcher("LoginPage.jsp");
			rd.include(request, response);

		}
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
