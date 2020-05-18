package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EskimoView extends PlayerView{
	private static BufferedImage eskimo;
	private static BufferedImage eskimoinwater;
	private static BufferedImage activeEskimo;

	public EskimoView() {
		try {
			if (eskimo == null)
				eskimo = ImageIO.read(new File("images" + File.separator + "eskimo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if (eskimoinwater == null)
				eskimoinwater = ImageIO.read(new File("images" + File.separator + "eskimo in water.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if (activeEskimo == null)
				activeEskimo = ImageIO.read(new File("images" + File.separator + "eskimo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Graphics g = activeEskimo.getGraphics();
		g.setColor(Color.RED);
		g.drawRect(0, 0, 31, 31);
		g.dispose();
	}
	
	public BufferedImage GetImage() {
		if(player.isInWater) 
			return eskimoinwater;
		else if (player.GetRemaningActions() > 0)
			return activeEskimo;
		else
			return eskimo;
	}
}
