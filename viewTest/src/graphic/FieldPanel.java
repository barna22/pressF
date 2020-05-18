package graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Megjelen�ti a kijel�lt IceField adatait.
 */
public class FieldPanel extends JPanel implements Updatable {

	IceField field;//a field, aminek az adatait ki�rja
	JLabel capacityValueLabel, snowLevelValueLabel, itemImageLabel; //labelek a kapacit�s, h�szint ki�r�s�hoz �s a befagyott t�rgy k�p�nek megjelen�t�s�hez

	public FieldPanel(IceField startingField) {
		this.field = startingField;

		//a layout be�ll�t�sa �s GridBagConstraints az elemek felpakol�s�hoz
		setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		//alap bet�t�pus a feliratoknak
		Font defaultFont = new Font("Arial", Font.PLAIN, 25);

		//a Capacity felirat label-je
		JLabel capacityLabel = new JLabel("Capacity:");
		capacityLabel.setHorizontalAlignment(JLabel.RIGHT);
		capacityLabel.setFont(defaultFont);
	    c.weightx = 0.3;
		c.weighty = 1.0f/3.0f;
		c.gridx = 0;
	    c.gridy = 0;
	    add(capacityLabel, c);

	    //a kapacit�st ki�r� label (pl.: 3/4 2/?)
	    capacityValueLabel = new JLabel("-");
	    capacityValueLabel.setHorizontalAlignment(JLabel.CENTER);
	    capacityValueLabel.setFont(defaultFont);
	    c.weightx = 0.7;
		c.weighty = 1.0f/3.0f;
		c.gridx = 1;
	    c.gridy = 0;
	    add(capacityValueLabel, c);

	    //a Snow level felirat label-je
	    JLabel snowLevelLabel = new JLabel("Snow level:");
	    snowLevelLabel.setHorizontalAlignment(JLabel.RIGHT);
	    snowLevelLabel.setFont(defaultFont);
	    c.weightx = 0.3;
		c.weighty = 1.0f/3.0f;
		c.gridx = 0;
	    c.gridy = 1;
	    add(snowLevelLabel, c);

	    //a h�szintet ki�r� label (pl.: 3)
	    snowLevelValueLabel = new JLabel("-");
	    snowLevelValueLabel.setHorizontalAlignment(JLabel.CENTER);
	    snowLevelValueLabel.setFont(defaultFont);
	    c.weightx = 0.7;
		c.weighty = 1.0f/3.0f;
		c.gridx = 1;
	    c.gridy = 1;
	    add(snowLevelValueLabel, c);

	    //az Item felirat label-je
	    JLabel itemLabel = new JLabel("Item:");
	    itemLabel.setHorizontalAlignment(JLabel.RIGHT);
	    itemLabel.setFont(defaultFont);
	    c.weightx = 0.3;
		c.weighty = 1.0f/3.0f;
		c.gridx = 0;
	    c.gridy = 2;
	    add(itemLabel, c);

	    //A panel, amiben megjelenik a nefagyott t�rgy
	    itemImageLabel = new JLabel();
	    //itemImageLabel.setBorder(BorderFactory.createLineBorder(Color.black));
	    c.weightx = 0.7;
		c.weighty = 1.0f/3.0f;
		c.gridx = 1;
	    c.gridy = 2;
	    //c.fill = GridBagConstraints.VERTICAL;
	    //c.insets = new Insets(30,80,30,80);
	    add(itemImageLabel, c);


	}

	/**
	 * Be�ll�tja az IceField-et, aminek az adatait meg kell jelen�teni
	 * @param field A be�ll�tand� IceField
	 */
	public void setField(IceField field) {
		this.field.removeFieldView(this);
		this.field = field;
		this.field.addFieldView(this);
		Update();
	}

	/**
	 * Friss�ti az elt�rolt IceField atadait megjelen�t� mez�ket.
	 */
	@Override
	public void Update() {
		if(field == null)
			return;

		itemImageLabel.setIcon(null);

		//a mez�n �ll� entit�sok sz�ma/kapacit�s (? ha m�g nem ismert a kapacit�s)
		String capacityText = Integer.toString(field.GetNumberOfEntities()).concat("/");
		int cap = field.GetCapacity();
		if(cap == 0 || field.isCapacityRevealed())
			capacityText = capacityText.concat(Integer.toString(cap));
		else
			capacityText = capacityText.concat("?");
		capacityValueLabel.setText(capacityText);

		//a h�szint
		snowLevelValueLabel.setText(Integer.toString(field.getSnowLevel()));

		//a befagyott t�rgy k�pe, ha nincs h� a mez�n
		/*if(field.getSnowLevel() == 0) {
			ItemView itemView = field.GetItem().GetView();
			if(itemView != null)
				itemImageLabel.setIcon(new ImageIcon(itemView.GetImage()));
		}*/
		if(field.getSnowLevel() == 0)
			itemImageLabel.setIcon(new ImageIcon(field.GetItem().GetView().GetImage()));

		revalidate();
	}

}
