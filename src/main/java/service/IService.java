package service;

import java.util.List;

import bean.PageBean;
import bean.Users;

public interface IService {
	void add(Users u);

	void delete(Integer uid);

	void edit(Users u);

	Users find(Integer uid);

	List<Users> find();

	PageBean findByPage(int p, int size);
}
