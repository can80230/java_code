package SingletonPattern;

// 懒汉模式
public class Wife2 {
	
	private static Wife2 wife;

	public Wife2() {
		
	}
	
	public static Wife2 getWife() {
		if(wife == null) {
			wife = new Wife2();
		}
		return wife;
	}

}
