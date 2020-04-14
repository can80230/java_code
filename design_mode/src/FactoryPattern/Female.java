package FactoryPattern;

// 创建实现类 Female
public class Female implements Human {

	@Override
	public void eat() {
		System.out.println("Female can eat.");
	}

	@Override
	public void sleep() {
		System.out.println("Female can sleep.");
	}

	@Override
	public void beat() {
		System.out.println("Female can beat.");
	}

}
