package abstractFactoryPattern;

public class AKitchen implements KitchenFactory {

	@Override
	public Food getFood() {
		return new Apple();
	}

	@Override
	public TableWare getTableWare() {
		return new Knife();
	}

}
