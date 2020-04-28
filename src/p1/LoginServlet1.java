package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginS")
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet1() {
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String str1=request.getParameter("txtemail");
		String str2=request.getParameter("txtpass");
		DBConnectionCls cls=new DBConnectionCls(str1,str2);
		int x=-1;
		try {
			x = cls.getRecords();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(x==2)
		{
			out.println("Successfully logged by admin");
			RequestDispatcher rd=request.getRequestDispatcher("product.jsp");
			rd.include(request, response);
		}
		else if(x==1)
		{
			out.println("Successfully logged by user");
			RequestDispatcher rd=request.getRequestDispatcher("productuser.jsp");
			rd.include(request, response);
		}
		else
		{
			out.println("Check Credentials");
			RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
			rd.include(request, response);

		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}








