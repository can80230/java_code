package abstractFactoryPattern;

public class Foodaholic {

	public void eat(KitchenFactory k) {
		System.out.println("A foodaholic is eating " + k.getFood().getFoodName()
				+ " with " + k.getTableWare().getToolName());
	}

	public static void main(String[] args) {
		Foodaholic fh = new Foodaholic();
		KitchenFactory kf = new AKitchen();
		fh.eat(kf);
	}

}
