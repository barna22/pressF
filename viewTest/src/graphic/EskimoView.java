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
		
		try {
			if (diver == null)
				diver = ImageIO.read(new File("images" + File.separator + "diver.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if (diverinwater == null)
				diverinwater = ImageIO.read(new File("images" + File.separator + "diver in water.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if (activediver == null)
				activediver = ImageIO.read(new File("images" + File.separator + "diver.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Graphics ge = activeEskimo.getGraphics();
		ge.setColor(Color.RED);
		ge.drawRect(0, 0, 31, 31);
		ge.dispose();
		
		Graphics gd = activediver.getGraphics();
		gd.setColor(Color.RED);
		gd.drawRect(0, 0, 31, 31);
		gd.dispose();
	}
	
	public BufferedImage GetImage() {
		if(player.isInWater) {
			return eskimoinwater;
		}else if (player.GetRemaningActions() > 0) {
			if(player.hasDivingGear) {
				return activediver;
			}else {
				return activeEskimo;
			}
		}else {
			return eskimo;
		}
	}
}
