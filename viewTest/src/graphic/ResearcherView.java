package graphic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResearcherView extends PlayerView{
	private static BufferedImage researcher;
	private static BufferedImage researcherinwater;
	
	public ResearcherView() {
		try {
			if (researcher == null)
				researcher = ImageIO.read(new File("images" + File.separator + "diver.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if (researcherinwater == null)
				researcherinwater = ImageIO.read(new File("images" + File.separator + "diver.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage GetImage() {
		if(player.isInWater) {
			return researcherinwater;
		}else {
			return researcher;
		}
	}
}
