package com.tjl.view;

import java.util.Scanner;

import com.til.bean.User;

public class View {
	
	private static Scanner input =new Scanner(System.in);
 
	
	//首页视图
	public static User indexView() {
		System.out.println("********************************************");
		System.out.println("***********\t\t学生信息管理系统\t\t***********");
		System.out.println("***********\t\t请根据提示操作\t\t*************");
		System.out.println("***********\t\t请输入账号:\t\t****************");
		String uname=input.nextLine();
		System.out.println("************\t\t请输入密码\t\t****************");
		String upass=input.nextLine();
		System.out.println("*********************************************");
		
		return new User(uname,upass);			
	}
//管理员视图
	public static int managerMenuView() {
		System.out.println("********************************************");
		System.out.println("***********\t\t欢迎管理员回家\t\t***********");
		System.out.println("***********\t\t请根据提示操作\t\t*************");
		System.out.println("***********\t\t请输入账号:\t\t****************");
		System.out.println("***********\t\t    0 退出        \t\t*************");
		System.out.println("***********\t\t    1 增加学生信息  \t\t*********");
		System.out.println("***********\t\t    2 删除学生信息  \t\t*********");
		System.out.println("***********\t\t    3 修改学生信息  \t\t*********");
		System.out.println("***********\t\t    4 查询学生信息  \t\t*********");
		String type=input.nextLine();
		//将获取到的数据转换为Int类
		int item = Integer.parseInt(type);
		if(item<0||item>4)
		{
			System.out.println("输入错误，请重新输入");
		    return managerMenuView();
		}
		System.out.println("*********************************************");
		
		return item;			
	}
	
	//添加学生信息视图
	public static User addMenuView() {
		System.out.println("********************************************");
		System.out.println("***********\t\t请根据提示操作\t\t*************");
		System.out.println("***********\t\t请输入新添加的账号:\t\t****************");
		String uname=input.nextLine();
		System.out.println("************\t\t请输入新的密码密码\t\t****************");
		String upass=input.nextLine();
		System.out.println("*********************************************");
		
		return new User(uname,upass);			
	}

	//删除学生信息菜单视图
	public static String deleteMenuView() {
		System.out.println("********************************************");
		System.out.println("***********\t\t请根据提示操作\t\t*************");
		System.out.println("***********\t\t请输入要删除的学生账号:\t\t****************");
		String uname=input.nextLine();
		System.out.println("*********************************************");
		
		return uname;			
	}
	
	/**修改学生信息
	 * @return
	 */
	public static User updateMenuView() {
		System.out.println("********************************************");
		System.out.println("***********\t\t请根据提示操作\t\t*************");
		System.out.println("***********\t\t请输入账号:\t\t****************");
		String uname=input.nextLine();
		System.out.println("************\t\t请输入新的密码\t\t****************");
		String upass=input.nextLine();
		System.out.println("*********************************************");
		
		return new User(uname,upass);			
	}

	public static String selectMenuView() {
		System.out.println("********************************************");
		System.out.println("***********\t\t请根据提示操作\t\t*************");
		System.out.println("***********\t\t请输入要选择的学生账号:\t\t****************");
		String uname=input.nextLine();
		System.out.println("*********************************************");
		
		return uname;			
	}
	
	public static void printUser(User user) {
		System.out.println("用户名id："+user.getId());
		System.out.println("用户名："+user.getUname());
		System.out.println("用户密码："+user.getUpass());
		if(user.getType()==1)
		{
			System.out.println("用户权限：学生");
		}else {
			System.out.println("用户权限：管理员");
		}
	}
	
}
