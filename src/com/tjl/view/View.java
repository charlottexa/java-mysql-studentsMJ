package com.tjl.view;

import java.util.Scanner;

import com.til.bean.User;

public class View {
	
	private static Scanner input =new Scanner(System.in);
 
	
	//��ҳ��ͼ
	public static User indexView() {
		System.out.println("********************************************");
		System.out.println("***********\t\tѧ����Ϣ����ϵͳ\t\t***********");
		System.out.println("***********\t\t�������ʾ����\t\t*************");
		System.out.println("***********\t\t�������˺�:\t\t****************");
		String uname=input.nextLine();
		System.out.println("************\t\t����������\t\t****************");
		String upass=input.nextLine();
		System.out.println("*********************************************");
		
		return new User(uname,upass);			
	}
//����Ա��ͼ
	public static int managerMenuView() {
		System.out.println("********************************************");
		System.out.println("***********\t\t��ӭ����Ա�ؼ�\t\t***********");
		System.out.println("***********\t\t�������ʾ����\t\t*************");
		System.out.println("***********\t\t�������˺�:\t\t****************");
		System.out.println("***********\t\t    0 �˳�        \t\t*************");
		System.out.println("***********\t\t    1 ����ѧ����Ϣ  \t\t*********");
		System.out.println("***********\t\t    2 ɾ��ѧ����Ϣ  \t\t*********");
		System.out.println("***********\t\t    3 �޸�ѧ����Ϣ  \t\t*********");
		System.out.println("***********\t\t    4 ��ѯѧ����Ϣ  \t\t*********");
		String type=input.nextLine();
		//����ȡ��������ת��ΪInt��
		int item = Integer.parseInt(type);
		if(item<0||item>4)
		{
			System.out.println("�����������������");
		    return managerMenuView();
		}
		System.out.println("*********************************************");
		
		return item;			
	}
	
	//���ѧ����Ϣ��ͼ
	public static User addMenuView() {
		System.out.println("********************************************");
		System.out.println("***********\t\t�������ʾ����\t\t*************");
		System.out.println("***********\t\t����������ӵ��˺�:\t\t****************");
		String uname=input.nextLine();
		System.out.println("************\t\t�������µ���������\t\t****************");
		String upass=input.nextLine();
		System.out.println("*********************************************");
		
		return new User(uname,upass);			
	}

	//ɾ��ѧ����Ϣ�˵���ͼ
	public static String deleteMenuView() {
		System.out.println("********************************************");
		System.out.println("***********\t\t�������ʾ����\t\t*************");
		System.out.println("***********\t\t������Ҫɾ����ѧ���˺�:\t\t****************");
		String uname=input.nextLine();
		System.out.println("*********************************************");
		
		return uname;			
	}
	
	/**�޸�ѧ����Ϣ
	 * @return
	 */
	public static User updateMenuView() {
		System.out.println("********************************************");
		System.out.println("***********\t\t�������ʾ����\t\t*************");
		System.out.println("***********\t\t�������˺�:\t\t****************");
		String uname=input.nextLine();
		System.out.println("************\t\t�������µ�����\t\t****************");
		String upass=input.nextLine();
		System.out.println("*********************************************");
		
		return new User(uname,upass);			
	}

	public static String selectMenuView() {
		System.out.println("********************************************");
		System.out.println("***********\t\t�������ʾ����\t\t*************");
		System.out.println("***********\t\t������Ҫѡ���ѧ���˺�:\t\t****************");
		String uname=input.nextLine();
		System.out.println("*********************************************");
		
		return uname;			
	}
	
	public static void printUser(User user) {
		System.out.println("�û���id��"+user.getId());
		System.out.println("�û�����"+user.getUname());
		System.out.println("�û����룺"+user.getUpass());
		if(user.getType()==1)
		{
			System.out.println("�û�Ȩ�ޣ�ѧ��");
		}else {
			System.out.println("�û�Ȩ�ޣ�����Ա");
		}
	}
	
}
