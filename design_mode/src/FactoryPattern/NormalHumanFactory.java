package FactoryPattern;

/* 创建普通工厂类 */
public class NormalHumanFactory {
	
	public Human createHuman(String gender) {
		if(gender.equals("male")) {
			return new Male();
		}
		else if(gender.equals("female")) {
			return new Female();
		}
		else {
			System.out.println("请输入正确的类型！");
			return null;
		}
	}
}
