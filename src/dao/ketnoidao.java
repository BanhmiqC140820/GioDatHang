package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ketnoidao {
	public Connection cn;
	public void ketnoi()  throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.print("da xac minh");
		String url="jdbc:sqlserver://LENNOVO\\SQLEXPRESS:1433;databaseName=QlSach;user=sa;password=123456";
		cn=DriverManager.getConnection(url);
		System.out.print("da ket noi");
	}
}
