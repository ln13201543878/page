package dao;

public class DaoFactory {
	
public static IUsersDao getUsersDao(){
	return new IUserDaoImpl();
}


}
