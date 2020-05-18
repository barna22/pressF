package graphic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FieldView extends JPanel implements Updatable, MouseListener {
	
	private IceField field;
	private static BufferedImage fieldImage, snowyFieldImage, igluImage, tentImage, itemImage, holeImage;
	private static boolean imagesLoaded = false;
	private static Area buildingArea = new Area(0.19, 0.12, 0.32, 0.32);
	private static Area entityArea = new Area(0.1, 0.45, 0.32, 0.32);
	private static Area itemArea = new Area(0.52, 0.02, 0.32, 0.32);
	private static Area waterArea = new Area(0.58, 0.67, 0.32, 0.16);

	public FieldView(IceField field) {
		addMouseListener(this);
		this.field = field;
		readImages();
	}

	/**
	 * Beolvassa a megjelen�t�shez haszn�lt k�peket
	 */
	private void readImages() {
		try {
			if (!imagesLoaded) {
				fieldImage = ImageIO.read(new File("images" + File.separator + "icefield.png")); // ha lenne k�l�n h� n�lk�li k�p ide k�ne
				snowyFieldImage = ImageIO.read(new File("images" + File.separator + "icefield.png"));
				igluImage = ImageIO.read(new File("images" + File.separator + "iglu.png"));
				tentImage = ImageIO.read(new File("images" + File.separator + "tent.png"));
				itemImage = ImageIO.read(new File("images" + File.separator + "bag.png"));
				holeImage = ImageIO.read(new File("images" + File.separator + "icefieldlyuk.png"));
				imagesLoaded = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Kirajzolja a j�gt�bl�t, az �llapot�nak megfelel�en
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		
		//j�gt�bla kirajzol�sa
		if (field.GetCapacity() == 0)
			Draw(holeImage, new Area(0, 0, 1, 1), g);
		else if(field.getSnowLevel() > 0)
			Draw(snowyFieldImage, new Area(0, 0, 1, 1), g);
		else
			Draw(fieldImage, new Area(0, 0, 1, 1), g);
		
		//iglu vagy s�tor megjelen�t�se
		if (field.HasIgloo())
			Draw(igluImage, buildingArea, g);
		else if(field.HasTent())
			Draw(tentImage, buildingArea, g);
		
		//entit�sok megjelen�t�se
		List<Entity> entities = field.GetEntities();
		for(Entity entity : entities) {
			BufferedImage entityImage = entity.GetView().GetImage();
			Draw(entityImage, entityArea, g);
		}
		
		//v�zbe esett j�t�kos megjelen�t�se
		List<Player> playersInWater = field.GetPlayersInWater();
		if(playersInWater.size() > 0) {
			BufferedImage playerImage = playersInWater.get(0).GetView().GetImage();
			Draw(playerImage, waterArea, g);
		}
		
		//Ki�shat� t�rgy megjelen�t�se
		if(field.getSnowLevel() == 0 && field.GetItem() != null)
			Draw(itemImage, itemArea, g);
	}
	
	/**
	 * Kirajzolja a megadott k�pet a megadott ter�letre
	 */
	private void Draw(BufferedImage image, Area area, Graphics g) {
		g.drawImage(image, (int)(area.x * getWidth()), (int)(area.y * getHeight()),
				(int)(area.w * getWidth()), (int)(area.h * getHeight()),
				null);
	}


	@Override
	public void Update() {
		this.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		GameView.instance.getFieldPanel().setField(field);
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
