package graphic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A jegesmedvéket megvalósító osztály
 */
public class IceBearView implements EntityView{
	
	private static BufferedImage bear;
	
	/**
	 * Beolvassuk a medve képét.
	 */
	public IceBearView () {
		try {
			if (bear == null)
				bear = ImageIO.read(new File("images" + File.separator + "polar bear.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public BufferedImage GetImage() {
		return bear;
	}

}
