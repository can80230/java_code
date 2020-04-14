package SingletonPattern;

// 饿汉模式
public class Wife1 {

	// 一开始就新建一个实例
	private static final Wife1 wife = new Wife1();

	public Wife1() {

	}

	public static Wife1 getWife() {
		return wife;
	}
}
