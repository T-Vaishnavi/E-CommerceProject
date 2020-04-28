package p1;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import javax.servlet.http.HttpSession;

public class DBConnectionCls {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
String productName="",description="",price="";
	public DBConnectionCls(String productName, String description, String price) {
		super();
		this.productName = productName;
		this.description = description;
		this.price = price;
	}
	public DBConnectionCls() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DBConnectionCls(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	String email="",password="",username="",phno="",address="";
	
	public DBConnectionCls(String email, String password, String username, String phno, String address) {
		super();
		this.email = email;
		this.password = password;
		this.username = username;
		this.phno = phno;
		this.address = address;
	}
	/*String dbEmpID="",dbEmail="";//data from database
	String empid="",email="",dept="", bonous="";
	public DBConnectionCls(String empid, String email) {
		super();
		this.empid = empid;
		this.email = email;
	}
	
	public DBConnectionCls(String empid, String dept, String email, String bonous) {
		super();
		this.empid = empid;
		this.dept = dept;
		this.email = email;
		this.bonous = bonous;
	}*/
	public Connection createConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con=DriverManager.getConnection("jdbc:sqlserver://LAPTOP-ACC7N5R1:1433;databaseName=Projectdb;user=sa;password=sa@123");
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
		ps=con.prepareStatement("insert users values  (?,?,?,?,?)");
		ps.setString(1,username);
		ps.setString(2,email);
		ps.setString(3,password);
		ps.setString(4,phno);
		ps.setString(5,address);
		/*ps.setInt(4,Integer.parseInt(bonous));*/
		int i=-1;
		i=ps.executeUpdate();
		return i;
	}
	public int storeElements() throws SQLException, ClassNotFoundException
	{
		createConnection();
		ps=con.prepareStatement("insert product values  (?,?,?)");
		ps.setString(1,productName);
		ps.setString(2,description);
		ps.setString(3,price);
		int l=-1;
		l=ps.executeUpdate();
		return l;
	}
	public ResultSet viewElements() throws ClassNotFoundException, SQLException
	{
		createConnection();
		ps=con.prepareStatement("select * from product");
		rs=ps.executeQuery();
		
		return rs;
	}
	
	public int deleteElements(String name) throws ClassNotFoundException, SQLException 
	{
		createConnection();
		ps=con.prepareStatement("delete product where productName=? ");
		ps.setString(1,name);
		int l=-1;
		l=ps.executeUpdate();
		if(l>0)
		{
			System.out.println("Deleted");
			l=1;
		}
		else
		{
			System.out.println("not Deleted");
			l=0;
		}
		return l;
	}
}
