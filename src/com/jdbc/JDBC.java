package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
	public static void main(String[] args)  {
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动加载成功");
			//连接数据库
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Shopping","root","what123");
			System.out.println("数据库连接成功");
			//创建执行环境
			Statement statement=conn.createStatement();
			//执行sql语句
			ResultSet result=statement.executeQuery("select * from storage");
			while(result.next()) {
				System.out.print(result.getString("Sno")+" ");
				 System.out.print(result.getString("Sname")+" ");
				 System.out.print(result.getString("Saddr")+" ");
				 System.out.print(result.getString("Mno")+" ");
				 System.out.println(result.getInt("Size"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("驱动加载失败");
			System.out.println("数据库连接失败");
		}
	}
}
