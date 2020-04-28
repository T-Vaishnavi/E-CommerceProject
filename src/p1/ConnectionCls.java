package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionCls {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
String productName="",description="",price="";
	public ConnectionCls(String productName, String description, String price) {
		super();
		this.productName = productName;
		this.description = description;
		this.price = price;
	}
	public ConnectionCls() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ConnectionCls(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	String email="",password="",username="",phno="";
	
	public ConnectionCls(String email, String password, String username, String phno ) {
		super();
		this.email = email;
		this.password = password;
		this.username = username;
		this.phno = phno;
		
	}
		public Connection createConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-TPNCD3P\\\\MSSQL2012:1433;databaseName=b200094;user=sa;password=vaishnavi@123");
		return con;
	}
	public int getRecords() throws ClassNotFoundException, SQLException 
	{
		createConnection();
		ps=con.prepareStatement("select email,password from users where email=? and password=?");
		ps.setString(1,email);
		ps.setString(2,password);
		rs=ps.executeQuery();
		while(rs.next())
		{
			email=rs.getString(1);
			password=rs.getString(2);
		}
		if(email.equals("admin@gmail.com")&&(password.equals("admin")))
		{
			return 2;
		}
		else if(email.equals("user@gmail.com")&&(password.equals("user")))
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	public int getElements() throws SQLException, ClassNotFoundException
	{
		createConnection();
		ps=con.prepareStatement("insert users values  (?,?,?,?)");
		ps.setString(1,username);
		ps.setString(2,email);
		ps.setString(3,password);
		ps.setString(4,phno);
		//ps.setString(5,address);
	
		int i=-1;
		i=ps.executeUpdate();
		return i;
	}
public int StoringRecords(String productName,String description,String price) throws ClassNotFoundException, SQLException 
{
	int i;
	createConnection();
	ps=con.prepareStatement("insert ProductDetails values  (?,?,?,?)");
	//ps.setString(1,this.productId);
	ps.setString(1,productName);
	//ps.setString(2,quantity);
	ps.setString(3,description);
	ps.setString(4,price);
	
	i=ps.executeUpdate();
	if(i>0)
	{
		System.out.println("Inserted");
	}
	else
	{
		System.out.println(" not Inserted");
	}
	
	return i;
	
	
}
public ResultSet view() throws ClassNotFoundException, SQLException
{
	createConnection();
	ps=con.prepareStatement("select * from ProductDetails");
	rs=ps.executeQuery();
	
	return rs;
}

public int delete(String name) throws ClassNotFoundException, SQLException 
{
	createConnection();
	ps=con.prepareStatement("delete ProductDetails where productname=?");
	ps.setString(1,name);
	int i=-1;
	i=ps.executeUpdate();
	if(i>0)
	{
		System.out.println("Deleted");
		i=1;
	}
	else
	{
		System.out.println("not Deleted");
		i=0;
	}
	return i;
}

}

