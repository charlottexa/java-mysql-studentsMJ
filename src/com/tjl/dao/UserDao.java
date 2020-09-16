package com.tjl.dao;

import com.til.bean.User;

/**
 * @author charlotte-xa
 *
 */
public interface UserDao {
	
	/**验证登陆方法
	 * @param user uname  upass
	 * @return int 类型  -1登录失败 1管理员登陆  2学生登陆
	 */
	int login(User user);
	
	
	/**添加学生信息
	 * @param user 要添加的对象  包括账户和密码
	 * @return  返回true添加失败   添加失败返回false
	 */
	boolean insert(User user);
	
	
	/**删除学生信息
	 * @param user 要删除的对象  包括账户和密码
	 * @return  返回true添加失败   添加失败返回false
	 */
	boolean delete(String uname);
	
	/**修改学生信息
	 * @param uname   user要修改对象包括账户和密码
	 * @return  成功返回true 失败返回false
	 */
	boolean update(User user);

	/**查询学生信息
	 * @param uname   要查询的学生的账号
	 * @return 成功返回user  失败返回null
	 */
	User select(String uname);
}
