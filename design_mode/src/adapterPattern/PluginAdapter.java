package adapterPattern;

/* 适配器 */
public class PluginAdapter implements CnPluginInterface {
	private EnPluginInterface enPlugin;
	
	public PluginAdapter(EnPluginInterface enPlugin) {
		this.enPlugin = enPlugin;
	}
	
	@Override
	public void chargeWith2Pins() {
		enPlugin.chargeWith3Pins();
	}

}
