package dao;

import java.util.List;

import bean.PageBean;
import bean.Users;
import utils.BaseDao;

public class IUserDaoImpl implements IUsersDao {
	BaseDao<Users>bd=new BaseDao<Users>();
	public void save(Users u) {
		String sql="insert into users values(null,?,?,?)";
		Object[] objs= {u.getUname(),u.getBirthday(),u.getUmoney()};
		bd.update(sql, objs);
	}

	public void delete(Integer uid) {
		String sql="delete from users where uid=?";
		Object[] objs= {uid};
		bd.update(sql, objs);
	}

	public void update(Users u) {
		String sql="update users set uname=?,birthday=?,umoney=? where uid=?";
		Object[] objs= {u.getUname(),u.getBirthday(),u.getUmoney(),u.getUid()};
		bd.update(sql, objs);
	}

	public Users find(Integer uid) {
		String sql="select * from users where uid=?";
		Object[] objs= {uid};
		List<Users>u=bd.select(sql, objs, Users.class);
		return u.size()==0?null:u.get(0);
	}

	public List<Users> find() {
		String sql="select * form users";
		Object[]objs= {};
		List<Users>users=bd.select(sql, objs, Users.class);
		return users;
	}

	public int getRowCount() {
		String sql="select * from users";
		Object[] objs= {};
		List<Users>users=bd.select(sql, objs, Users.class);
		return users.size();
		
	}

	public List<Users> findByPage(int startLine, int size) {
		String sql="select * from users limit ?,?";
		Object[]objs= {startLine,size};
		List<Users>user=bd.select(sql, objs, Users.class);
		return user;
	}

	
}
