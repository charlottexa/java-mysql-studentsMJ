package com.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
     
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	//静态语块
	static {
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
		//创建property类型对象
		Properties p = new Properties();
		//加载流文件
		try {
			p.load(is);
			driver = p.getProperty("driver");
		    url = p.getProperty("url");
			username = p.getProperty("username");
			password = p.getProperty("password");
			//加载驱动
	    Class.forName(driver);
	    System.out.println("驱动加载成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	public static Connection getConnection() {
		try {
			System.out.println("数据库连接成功");
			return DriverManager.getConnection(url,username,password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//释放资源的方法
	public static void close(Connection conn,Statement statement,ResultSet result) 
	{
			
		try {
			if(result!=null) 
			{
				result.close();
				result = null;
				
			} 
			
			if(statement!=null) 
			{
				statement.close();
				statement = null;
				
			} 
			
			if(conn!=null) 
			{
				conn.close();
				conn = null;
				
			} 
		}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
