import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.providers.AbstractMapProvider;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.providers.StamenMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;


public class WorldView extends PApplet
{
	private static final long serialVersionUID = 1L;

	/** This is where to find the local tiles, for working without an Internet connection */
	public static String mbTilesString = "blankLight-1-3.mbtiles";
	
	// IF YOU ARE WORKING OFFLINE: Change the value of this variable to true
	private static final boolean offline = false;
	
	UnfoldingMap map1;
	
	UnfoldingMap map2;

	public void setup() {
		size(800, 600, P2D);  

		this.background(200, 200, 200);
		
		
		AbstractMapProvider provider = new OpenStreetMap.OpenStreetMapProvider();
		// Set a zoom level
		int zoomLevel = 10;
		
		if (offline) {
			// If you are working offline, you need to use this provider 
			// to work with the maps that are local on your computer.  
			provider = new MBTilesMapProvider(mbTilesString);
			// 3 is the maximum zoom level for working offline
			zoomLevel = 3;
		}
		
		// Create a new UnfoldingMap to be displayed in this window.  
		// The 2nd-5th arguments give the map's x, y, width and height
		
		map1 = new UnfoldingMap(this, 50, 50, 350, 500, provider);
		
		map2 = new UnfoldingMap(this, 450, 50, 350, 500, provider);
		
	    map1.zoomAndPanTo(zoomLevel, new Location(32.9f, -117.2f));
	    
	    map2.zoomAndPanTo(zoomLevel, new Location(28.7f, 77.1f));
		
		// This line makes the map interactive
		MapUtils.createDefaultEventDispatcher(this, map1);
		MapUtils.createDefaultEventDispatcher(this, map2);

	}

	/** Draw the Applet window.  */
	public void draw() {
		
		map1.draw();
		map2.draw();
	}

	
}
