package com.tjl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.JDBCUtils;
import com.til.bean.User;

public class UserDao_Imp implements UserDao {
	
	private static final String SQL_USER_LOGIN="SELECT TYPE FROM USER WHERE UNAME=? AND UPASS=?";
	private static final String SQL_USER_INSERT = "INSERT INTO USER VALUES(id,?,?,1)";
	private static final String SQL_USER_DELETE = "DELETE FROM USER WHERE UNAME=?";
	private static final String SQL_USER_UPDATE = "UPDATE USER SET UPASS=? WHERE UNAME=?";
	private static final String SQL_USER_SELECT = "SELECT * FROM USER WHERE UNAME=?";

	@Override
	public int login(User user) {
		// TODO Auto-generated method stub
		
		//连接数据库，创建连接环境conn
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		
		try {
			//创建预编译环境
			prepareStatement = conn.prepareStatement(SQL_USER_LOGIN);
			
			//设置sql语句中的参数
			prepareStatement.setString(1,user.getUname());
			prepareStatement.setString(2,user.getUpass());
			
			//执行语句
			result = prepareStatement.executeQuery();
			while(result.next()){
				//用结果集查询当前用户权限
				int type = result.getInt("type");
				return type;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn, prepareStatement, result);
		}
		return -1;
	}

	
	@Override
	public boolean insert(User user) {
		// TODO Auto-generated method stub
		//创建执行环境
		Connection conn = JDBCUtils.getConnection();
		//创建预编译环境
		PreparedStatement prepareStatement = null;
		
		try {
			prepareStatement = conn.prepareStatement(SQL_USER_INSERT);
			//设置sql语句参数
			prepareStatement.setString(1, user.getUname());
			prepareStatement.setString(2, user.getUpass());
			
			int line = prepareStatement.executeUpdate();
            return line>0?true:false;
            		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.close(conn, prepareStatement, null);
		}
		return false;
	}

	public boolean delete(String uname) {
		// TODO Auto-generated method stub
		
		Connection conn = JDBCUtils.getConnection();
		//创建预编译环境
		PreparedStatement prepareStatement = null;
		
		try {
			prepareStatement = conn.prepareStatement(SQL_USER_DELETE);
			//设置sql语句参数
			prepareStatement.setString(1, uname);
			int line = prepareStatement.executeUpdate();
            
			return line>0?true:false;
            		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.close(conn, prepareStatement, null);
		}
		return false;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		//创建执行环境
		Connection conn = JDBCUtils.getConnection();
		//创建预编译环境
		PreparedStatement prepareStatement = null;
		
		try {
			prepareStatement = conn.prepareStatement(SQL_USER_UPDATE);
			//设置sql语句参数
			prepareStatement.setString(1, user.getUpass());
			prepareStatement.setString(2, user.getUname());
			
			int line = prepareStatement.executeUpdate();
            return line>0?true:false;
            		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.close(conn, prepareStatement, null);
		}
		return false;
	}

	public User select(String uname) {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtils.getConnection();
		//创建预编译环境
		PreparedStatement prepareStatement = null;
		
		try {
			prepareStatement = conn.prepareStatement(SQL_USER_SELECT);
			//设置sql语句参数
			prepareStatement.setString(1, uname);
		    ResultSet result = prepareStatement.executeQuery();
            while(result.next())
            {
            	int id = result.getInt("id");
            	uname = result.getString("uname");
            	String upass = result.getString("upass");
            	int type = result.getInt("type");
            	if(type==1) {
            		String user1 = new String("学生");
            	}else
            	{
            		String user1 = new String("管理员");
            	}
            	
            	return new User(uname,id,upass,type); 	
            }
            	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.close(conn, prepareStatement, null);
		}
		return null;
	}

}
