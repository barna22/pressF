package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResearcherView extends PlayerView{
	private static BufferedImage researcher;
	private static BufferedImage researcherinwater;
	private static BufferedImage activeResearcher;
	
	/**
	 * Beolvassa a képeket, amikre szüksége lesz a researchernek.
	 * Külön képeket csinál az aktív játékos jelzésére.
	 */
	public ResearcherView() {
		try {
			if (researcher == null)
				researcher = ImageIO.read(new File("images" + File.separator + "researcher scarf.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if (researcherinwater == null)
				researcherinwater = ImageIO.read(new File("images" + File.separator + "researcher in water.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if (activeResearcher == null)
				activeResearcher = ImageIO.read(new File("images" + File.separator + "researcher scarf.png"));
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
			if (activeResearcher == null)
				activeResearcher = ImageIO.read(new File("images" + File.separator + "diver.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if (activediver == null)
				activediver = ImageIO.read(new File("images" + File.separator + "diver.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Az aktív játékosnak legyen egy piros négyzet a képén
		Graphics gr = activeResearcher.getGraphics();
		gr.setColor(Color.RED);
		gr.drawRect(0, 0, 31, 31);
		gr.dispose();
		
		Graphics gd = activediver.getGraphics();
		gd.setColor(Color.RED);
		gd.drawRect(0, 0, 31, 31);
		gd.dispose();
	}
	
	/**
	 * Visszatér az állapotnak megfelelő képpel.
	 */
	public BufferedImage GetImage() {
		if(player.isInWater)
			return researcherinwater;
		else if (player.GetRemaningActions() > 0) {
			if (player.hasDivingGear) {
				return activediver;
			}else {
				return activeResearcher;
			}
		}else {
			if(player.hasDivingGear) {
				return diver;
			}else {
				return researcher;
			}
		}	
	}
}
