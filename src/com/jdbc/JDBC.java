package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
	public static void main(String[] args)  {
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�������سɹ�");
			//�������ݿ�
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Shopping","root","what123");
			System.out.println("���ݿ����ӳɹ�");
			//����ִ�л���
			Statement statement=conn.createStatement();
			//ִ��sql���
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
			System.out.println("��������ʧ��");
			System.out.println("���ݿ�����ʧ��");
		}
	}
}
