package SingletonPattern;

// 懒汉模式（线程安全）
public class Wife3 {
	
	private volatile static Wife3 wife;

	public Wife3() {

	}
	
//	public static synchronized Wife3 getWife() {
//		if(wife == null) {
//			wife = new Wife3();
//		}
//		return wife;
//	}
	
	// 双重锁的getWife() 方法
	public static Wife3 getWife() {
		if(wife == null) {
			synchronized (Wife3.class) {
				if(wife == null) {
					wife = new Wife3();
				}
			}
		}
		return wife;
	}

}
