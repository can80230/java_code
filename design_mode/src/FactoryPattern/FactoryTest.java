package FactoryPattern;

/* 工厂测试类 */
public class FactoryTest {

	public static void main(String[] args) {
		/* 普通工厂模式 */
		NormalHumanFactory factory = new NormalHumanFactory();
		Human male = factory.createHuman("male");
		male.eat();
		male.sleep();
		male.beat();
		
		/* 多个工厂方法模式 */
		MultipleHumanFactory factory1 = new MultipleHumanFactory();
		Human female = factory1.createFemale();
		female.beat();
		female.sleep();
		female.beat();
		
		/* 静态工厂方法模式 */
		Human male1 = StaticHumanFactory.createMale();
		male1.eat();
		male1.sleep();
		male1.beat();
	}

}
