package dao;

import java.util.List;

import bean.PageBean;
import bean.Users;

public interface IUsersDao {
void save(Users u);
void delete(Integer uid);
void update(Users u);
Users find(Integer uid);
List<Users>find();
int getRowCount();
List<Users>findByPage(int startLine,int size);
}
