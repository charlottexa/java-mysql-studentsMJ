package com.tjl.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jdbc.JDBCUtils;
import com.til.bean.User;
import com.tjl.dao.UserDao_Imp;

import org.junit.Test;



public class JDBCUtilsTest {
	
//junit����ǰҪ���������в���	
@Test
	public void jdbcConnectionTest() throws Exception{
		Connection conn = JDBCUtils.getConnection();
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery("select * from storage");
		while(result.next()) {
			 System.out.print(result.getString("Sno")+" ");
		}
	}

//�����û���½
 @Test
    public void loginTest() throws Exception {
	 UserDao_Imp userDao_Imp = new UserDao_Imp();
	 User user = new User("������","lqz");
	 int type = userDao_Imp.login(user);
	 System.out.println(type);
}
 
 //��������û�
 @Test
     public void insertTest() throws Exception {
	 UserDao_Imp userDao_Imp = new UserDao_Imp();
	 User user = new User("��ϼ��","xxk");
	 boolean flag = userDao_Imp.insert(user);
	 System.out.println(flag);
}
 
  //����ɾ��
    @Test
     public void deleteTest() throws Exception {
    	UserDao_Imp userDao_Imp = new UserDao_Imp();
   	    User user = new User("��ϼ��","xxk");
   	    boolean flag = userDao_Imp.delete(user.getUname());
   	    System.out.println(flag);
	
}
    
    //���Ը���
    @Test
	public void updateTest() throws Exception {
    	UserDao_Imp userDao_Imp = new UserDao_Imp();
   	    User user = new User("���","lb");
   	    boolean flag = userDao_Imp.update(user);
   	    System.out.println(flag);	
	}

    
    @Test
	public void selectTest() throws Exception {
    	UserDao_Imp userDao_Imp = new UserDao_Imp();
    	User user = new User("zhangsan","wuli");
    	User user3 = userDao_Imp.select(user.getUname());
    	System.out.println(user3);
		
	}
}
