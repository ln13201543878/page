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
		// �����ߵ����page.getStartLine()��28�� page.getSize()��7
		
		// ����page����һ����10�����ԣ�����Ψ��listû��ֵ��
		List<Users> list = dao.findByPage(page.getStartLine(), page.getSize());
		page.setList(list);
		
		return page;
	}



}
