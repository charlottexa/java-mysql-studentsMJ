package com.tjl.test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import com.til.bean.User;
import com.tjl.view.View;

public class ViewTest {
	private User updataMenuView;

	//���Ե�¼ҳ
	@Test
	public void indexViewTest() throws Exception
	{
	User user1 = View.indexView();
	System.out.println(user1);
	}
	
	
	//���Թ���Ա�˵�
    @Test
	public void managerMenuTest() throws Exception {
    	int item = View.managerMenuView();
		System.out.println(item);
	}
	
    //�������ѧ����Ϣ
	@Test
	public void addMenuViewTest() throws Exception {
		User user2 = View.addMenuView();
		System.out.println(user2);
		
	}
	
	//ɾ��ѧ����Ϣ
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
