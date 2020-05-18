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
		
		Graphics g = activeResearcher.getGraphics();
		g.setColor(Color.RED);
		g.drawRect(0, 0, 31, 31);
		g.dispose();
	}
	
	public BufferedImage GetImage() {
		if(player.isInWater)
			return researcherinwater;
		else if (player.GetRemaningActions() > 0)
			return activeResearcher;
		else 
			return researcher;
	}
}
