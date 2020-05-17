package proto;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FieldView extends JPanel implements Updatable {
	
	private IceField field;
	private static BufferedImage fieldImage, igluImage, tentImage, itemImage;
	private static boolean imagesLoaded = false;
	private static Area buildingArea = new Area(0.19, 0.12, 0.32, 0.32);
	private static Area entityArea = new Area(0.1, 0.45, 0.32, 0.32);
	private static Area itemArea = new Area(0.52, 0.18, 0.32, 0.16);
	private static Area waterArea = new Area(0.58, 0.67, 0.32, 0.16);

	public FieldView(IceField field) {
		this.field = field;
		readImages();
	}

	/**
	 * Beolvassa a megjelenítéshez használt képeket
	 */
	private void readImages() {
		try {
			if (!imagesLoaded) {
				fieldImage = ImageIO.read(new File("images" + File.separator + "icefield.png"));
				igluImage = ImageIO.read(new File("images" + File.separator + "iglu.png"));
				tentImage = ImageIO.read(new File("images" + File.separator + "tent.png"));
				itemImage = ImageIO.read(new File("images" + File.separator + "item.png"));
				imagesLoaded = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Kirajzolja a jégtáblát, az állapotának megfelelõen
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		
		//jégtábla kirajzolása
		g.drawImage(fieldImage, 0, 0, getWidth(), getHeight(),
				0, 0, fieldImage.getWidth(), fieldImage.getHeight(), null);
		
		//iglu vagy sátor megjelenítése
		if (field.HasIgloo())
			g.drawImage(igluImage, (int)(buildingArea.x * getWidth()), (int)(buildingArea.y * getHeight()),
					(int)(buildingArea.w * getWidth()), (int)(buildingArea.h * getHeight()),
					0, 0, igluImage.getWidth(), igluImage.getHeight(), null);
		else if(field.HasTent())
			g.drawImage(tentImage, (int)(buildingArea.x * getWidth()), (int)(buildingArea.y * getHeight()),
					(int)(buildingArea.w * getWidth()), (int)(buildingArea.h * getHeight()),
					0, 0, tentImage.getWidth(), tentImage.getHeight(), null);
	}

	// törlendõ
	public void draw() {
		this.repaint();
	}

	@Override
	public void update() {
		this.repaint();
	}
}
