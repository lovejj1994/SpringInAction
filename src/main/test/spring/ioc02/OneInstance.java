package spring.ioc02;

public class OneInstance {
	
	public static class GetInstanceHolder{
		static OneInstance oneInstance = new OneInstance();
	}
	
	public static OneInstance getInstance(){
		return GetInstanceHolder.oneInstance;
	}
	
	public void finish(){
		System.out.println("实例化完成");
	}
}
