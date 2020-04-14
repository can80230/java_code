package adapterPattern;

public class Home {
	private CnPluginInterface cnPlugin;
	
	public Home() {
		
	}
	
	public Home(CnPluginInterface cnPlugin) {
		this.cnPlugin = cnPlugin;
	}
	
	public void setPlugin(CnPluginInterface cnPlugin) {
		this.cnPlugin = cnPlugin;
	}
	
	public void charge() {
		cnPlugin.chargeWith2Pins();
	}
}
