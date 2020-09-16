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
	
//junit测试前要加下面这行才行	
@Test
	public void jdbcConnectionTest() throws Exception{
		Connection conn = JDBCUtils.getConnection();
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery("select * from storage");
		while(result.next()) {
			 System.out.print(result.getString("Sno")+" ");
		}
	}

//测试用户登陆
 @Test
    public void loginTest() throws Exception {
	 UserDao_Imp userDao_Imp = new UserDao_Imp();
	 User user = new User("李清照","lqz");
	 int type = userDao_Imp.login(user);
	 System.out.println(type);
}
 
 //测试添加用户
 @Test
     public void insertTest() throws Exception {
	 UserDao_Imp userDao_Imp = new UserDao_Imp();
	 User user = new User("徐霞客","xxk");
	 boolean flag = userDao_Imp.insert(user);
	 System.out.println(flag);
}
 
  //测试删除
    @Test
     public void deleteTest() throws Exception {
    	UserDao_Imp userDao_Imp = new UserDao_Imp();
   	    User user = new User("徐霞客","xxk");
   	    boolean flag = userDao_Imp.delete(user.getUname());
   	    System.out.println(flag);
	
}
    
    //测试更新
    @Test
	public void updateTest() throws Exception {
    	UserDao_Imp userDao_Imp = new UserDao_Imp();
   	    User user = new User("李白","lb");
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
