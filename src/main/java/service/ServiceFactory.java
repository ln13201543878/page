package service;

public class ServiceFactory {

	public static IService getServiceImpl() {
		return new IUserserviceImpl();
	}
}
