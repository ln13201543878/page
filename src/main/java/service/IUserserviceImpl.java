package service;

import java.util.List;

import bean.PageBean;
import bean.Users;
import dao.DaoFactory;
import dao.IUserDaoImpl;

public class IUserserviceImpl implements IService {
	IUserDaoImpl dao=new IUserDaoImpl();
	public void add(Users u) {
		DaoFactory.getUsersDao().save(u);
	}

	public void delete(Integer uid) {
		DaoFactory.getUsersDao().delete(uid);
	}

	public void edit(Users u) {
		DaoFactory.getUsersDao().update(u);
	}

	public Users find(Integer uid) {
		return	DaoFactory.getUsersDao().find(uid);
		 
	}

	public List<Users> find() {
		return DaoFactory.getUsersDao().find();
	}

	public PageBean findByPage(int p, int size) {
		int rowCount = dao.getRowCount();
		// p = 5;  rowCount = 88;  size = 7;
		PageBean page=new PageBean(p,rowCount,size);
		// 流程走到这里，page.getStartLine()是28， page.getSize()是7
		
		// 而且page对象一共有10个属性，现在唯独list没有值！
		List<Users> list = dao.findByPage(page.getStartLine(), page.getSize());
		page.setList(list);
		
		return page;
	}



}
