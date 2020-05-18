package graphic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EskimoView extends PlayerView{
	private static BufferedImage eskimo;
	private static BufferedImage eskimoinwater;

	public EskimoView() {
		try {
			if (eskimo == null)
				eskimo = ImageIO.read(new File("images" + File.separator + "diver.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if (eskimoinwater == null)
				eskimoinwater = ImageIO.read(new File("images" + File.separator + "diver.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage GetImage() {
		if(player.isInWater) {
			return eskimoinwater;
		}else {
			return eskimo;
		}
	}
}
