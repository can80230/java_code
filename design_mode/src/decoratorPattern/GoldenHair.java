package decoratorPattern;

public class GoldenHair extends GirlDecorator {
	
	private Girl girl;
	
	public GoldenHair(Girl g) {
		girl = g;
	}

	@Override
	public String getDescription() {
		return girl.getDescription() + "+with golden hairs";
	}
	
}
