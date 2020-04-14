package FactoryPattern;

public class StaticHumanFactory {
	
	public static Male createMale() {
        return new Male();
    }
	
    public static Female createFemale() {
        return new Female();
    }
}
