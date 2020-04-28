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

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/StoreProduct")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String str1=request.getParameter("txtid");
		String str2=request.getParameter("txtname");
		String str3=request.getParameter("txtquan");
		String str4=request.getParameter("txtdes");
		String str5=request.getParameter("txtpri");
		//System.out.println(str1+" "+str2);
		ConnectionCls cls=new ConnectionCls(str1,str2,str3,str4);
		int i=1;
		try
		{
			i=cls.StoringRecords();
		}
		catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		if(i>0)
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("ProductAdmin.jsp");
			rd.include(request,response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("ProductDetails.jsp");
			rd.include(request,response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
