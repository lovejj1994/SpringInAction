package rmi;

import java.rmi.Naming;

public class Client {
	public static void main(String[] args) {
		String url = "rmi://localhost:8887/";
		try {
			// 在RMI服务注册表中查找名称为service02的对象，并调用其上的方法
			IService service02 = (IService) Naming.lookup(url + "service02");

			Class stubClass = service02.getClass();
			System.out.println(service02 + " 是 " + stubClass.getName()
					+ " 的实例！");
			// 获得本底存根已实现的接口类型
			Class[] interfaces = stubClass.getInterfaces();
			for (Class c : interfaces) {
				System.out.println("存根类实现了 " + c.getName() + " 接口！");
			}
			System.out.println(service02.service("你好！"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
