package FactoryPattern;

public class MultipleHumanFactory {
	
	public Male createMale() {
		return new Male();
	}
	
	public Female createFemale() {
		return new Female();
	}
}
