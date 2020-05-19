package graphic;

import java.awt.image.BufferedImage;

public class PlayerView implements EntityView{
	
	protected static BufferedImage diverinwater;
	protected static BufferedImage diver;
	protected static BufferedImage activediver;
	protected Player player;
	
	@Override
	public BufferedImage GetImage() {
		if(player.isInWater) {
			return diverinwater;
		}else {
			return diver;
		}
	}	
	
	public void SetPlayer(Player p) {
		player = p;
	}
}
