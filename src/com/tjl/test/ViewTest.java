package com.tjl.test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import com.til.bean.User;
import com.tjl.view.View;

public class ViewTest {
	private User updataMenuView;

	//测试登录页
	@Test
	public void indexViewTest() throws Exception
	{
	User user1 = View.indexView();
	System.out.println(user1);
	}
	
	
	//测试管理员菜单
    @Test
	public void managerMenuTest() throws Exception {
    	int item = View.managerMenuView();
		System.out.println(item);
	}
	
    //测试添加学生信息
	@Test
	public void addMenuViewTest() throws Exception {
		User user2 = View.addMenuView();
		System.out.println(user2);
		
	}
	
	//删除学生信息
	@Test
	public void deleteMenuViewTest() throws Exception {
		String uname1 = View.deleteMenuView();
		System.out.println(uname1);
	}

	@Test
	public void updateMenuViewTest() throws Exception {
		User user3 = View.updateMenuView();
		System.out.println(user3);
		
	}
}
