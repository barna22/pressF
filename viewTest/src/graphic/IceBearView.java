package graphic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class IceBearView implements EntityView{
	
	private static BufferedImage bear;
	
	public IceBearView () {
		try {
			if (bear == null)
				bear = ImageIO.read(new File("images" + File.separator + "diver.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public BufferedImage GetImage() {
		return bear;
	}

}
