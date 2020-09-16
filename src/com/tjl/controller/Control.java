package com.tjl.controller;

import com.til.bean.User;
import com.tjl.dao.UserDao_Imp;
import com.tjl.view.View;

public class Control {
	public static void main(String[] args)
	{
		while(true) {
		//给用户展示登陆页面
		User user = View.indexView();
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		int type = userDao_Imp.login(user);
		switch(type)
		{
		case -1:
			System.out.println("输入有误，请重新输入！");
			break;
		case 1:
			//System.out.println("恭喜学生成功登陆");
			//控制学生系统
			studentServer();
			break;
		case 2:
			//System.out.println("恭喜管理员成功登陆");
			//控制管理员系统
			managerServer();
			break;
		default:
			break;
		}
		
	}

}
	
	private static void studentServer() {
		
		//学生管理系统
		
	}
	
	private static void managerServer() {
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		while(true) {
			//展示管理员菜单
			int item = View.managerMenuView();
			boolean flag;
			switch(item){
			//退出
				case 0:
					System.exit(-1);
					break;
			//添加学生信息	
				case 1:
				    User user = View.addMenuView();
				    flag = userDao_Imp.insert(user);
				    System.out.println(flag?"add success":"add fail");
					break;
			//删除
				case 2:
					String uname = View.deleteMenuView();
					flag = userDao_Imp.delete(uname);
					System.out.println(flag?"delete success":"delete fail");
					break;
		    //修改	
				case 3:
					User user1 = View.updateMenuView();
					flag = userDao_Imp.update(user1);
					System.out.println(flag?"update success":"update fail");
				    break;
		    //查找	
				case 4:
					String uname1 = View.selectMenuView();
					User user3 = userDao_Imp.select(uname1);
					View.printUser(user3);
				    break;
				default:
				    	break;
									
			}
		}
		
		
	}
}
