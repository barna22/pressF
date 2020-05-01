package proto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FieldView extends JPanel {
	private IceField field;
	private static BufferedImage diver;

	public FieldView(IceField field) {
		this.field = field;
		try {
			if (diver == null)
				diver = ImageIO.read(new File("images" + File.separator + "diver.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		
		 g.setColor(Color.BLUE); g.fillRect(0, 0, getWidth(), getHeight());
		 
		 Point center = new Point(getWidth() / 2, getHeight() / 2);
		 int ovalWidth = (int) (getWidth() * 0.9); int ovalHeight = (int) (getHeight() * 0.9);
		 g.setColor(Color.WHITE); g.fillOval(center.x - ovalWidth / 2, center.y - ovalHeight / 2, ovalWidth, ovalHeight);
		 
		 g.drawImage(diver,
				 (int)(getWidth() * 0.2), (int)(getHeight() * 0.2), (int)(getWidth() * 0.4), (int)(getHeight() * 0.4),
				 0, 0, 32, 32,
				 null);
		 
		 g.drawImage(diver,
				 (int)(getWidth() * 0.2), (int)(getHeight() * 0.2), (int)(getWidth() * 0.4), (int)(getHeight() * 0.4),
				 0, 0, 32, 32,
				 null);
		 
		/*g.setColor(Color.BLUE);
		g.fillRect(0, 0, getWidth(), getHeight());
		Point center = new Point(getWidth() / 2, getHeight() / 2);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, (int) (center.getX()), (int) (center.getY()));*/

	}
}
