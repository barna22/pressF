package graphic;

import java.awt.image.BufferedImage;

public class PlayerView implements EntityView{
	
	private static BufferedImage diverinwater;
	private static BufferedImage diver;
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
