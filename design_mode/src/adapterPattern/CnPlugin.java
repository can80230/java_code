package adapterPattern;

public class CnPlugin implements CnPluginInterface {

	@Override
	public void chargeWith2Pins() {
		System.out.println("charge with CnPlugin");
	}

}
