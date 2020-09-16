package com.tjl.controller;

import com.til.bean.User;
import com.tjl.dao.UserDao_Imp;
import com.tjl.view.View;

public class Control {
	public static void main(String[] args)
	{
		while(true) {
		//���û�չʾ��½ҳ��
		User user = View.indexView();
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		int type = userDao_Imp.login(user);
		switch(type)
		{
		case -1:
			System.out.println("�����������������룡");
			break;
		case 1:
			//System.out.println("��ϲѧ���ɹ���½");
			//����ѧ��ϵͳ
			studentServer();
			break;
		case 2:
			//System.out.println("��ϲ����Ա�ɹ���½");
			//���ƹ���Աϵͳ
			managerServer();
			break;
		default:
			break;
		}
		
	}

}
	
	private static void studentServer() {
		
		//ѧ������ϵͳ
		
	}
	
	private static void managerServer() {
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		while(true) {
			//չʾ����Ա�˵�
			int item = View.managerMenuView();
			boolean flag;
			switch(item){
			//�˳�
				case 0:
					System.exit(-1);
					break;
			//���ѧ����Ϣ	
				case 1:
				    User user = View.addMenuView();
				    flag = userDao_Imp.insert(user);
				    System.out.println(flag?"add success":"add fail");
					break;
			//ɾ��
				case 2:
					String uname = View.deleteMenuView();
					flag = userDao_Imp.delete(uname);
					System.out.println(flag?"delete success":"delete fail");
					break;
		    //�޸�	
				case 3:
					User user1 = View.updateMenuView();
					flag = userDao_Imp.update(user1);
					System.out.println(flag?"update success":"update fail");
				    break;
		    //����	
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
