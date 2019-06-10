package web;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bean.PageBean;
import bean.Users;
import service.ServiceFactory;

public class UsersAction extends ActionSupport implements ModelDriven<Users> {
	private int p;
	private Users user=new Users();
	
	
	public String save() {
		ServiceFactory.getServiceImpl().add(user);
		return "findAll";
	}
	public String update() {
		ServiceFactory.getServiceImpl().edit(user);
		return "findAll";
	}
	public String delete() {
		ServiceFactory.getServiceImpl().delete(user.getUid());
		return "findAll";
	}
	public String findAll() {
		PageBean pb=ServiceFactory.getServiceImpl().findByPage(p, 5);
		ServletActionContext.getRequest().setAttribute("pb", pb);
		return "findUI";
	}
	
	public String findOne() {
		user=ServiceFactory.getServiceImpl().find(user.getUid());
		ServletActionContext.getRequest().setAttribute("user", user);
		return "edit";
	}
	
	public Users getModel() {
		
		return user;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	

}
