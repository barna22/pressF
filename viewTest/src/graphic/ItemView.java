package graphic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ItemView{
	private Item item;
	private BufferedImage itemimage;
	
	public ItemView(String imagename) {
		try {
			if (itemimage == null)
				itemimage = ImageIO.read(new File("images" + File.separator + imagename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage GetImage() {
		return itemimage;
	}
	
	public void SetItem(Item i) {
		item = i;
	}
}