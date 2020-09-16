package com.tjl.dao;

import com.til.bean.User;

/**
 * @author charlotte-xa
 *
 */
public interface UserDao {
	
	/**��֤��½����
	 * @param user uname  upass
	 * @return int ����  -1��¼ʧ�� 1����Ա��½  2ѧ����½
	 */
	int login(User user);
	
	
	/**���ѧ����Ϣ
	 * @param user Ҫ��ӵĶ���  �����˻�������
	 * @return  ����true���ʧ��   ���ʧ�ܷ���false
	 */
	boolean insert(User user);
	
	
	/**ɾ��ѧ����Ϣ
	 * @param user Ҫɾ���Ķ���  �����˻�������
	 * @return  ����true���ʧ��   ���ʧ�ܷ���false
	 */
	boolean delete(String uname);
	
	/**�޸�ѧ����Ϣ
	 * @param uname   userҪ�޸Ķ�������˻�������
	 * @return  �ɹ�����true ʧ�ܷ���false
	 */
	boolean update(User user);

	/**��ѯѧ����Ϣ
	 * @param uname   Ҫ��ѯ��ѧ�����˺�
	 * @return �ɹ�����user  ʧ�ܷ���null
	 */
	User select(String uname);
}
