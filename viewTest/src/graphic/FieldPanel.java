package graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Megjeleniti a kijelolt IceField adatait.
 */
public class FieldPanel extends JPanel implements Updatable {

	IceField field;//a field, aminek az adatait kiirja
	JLabel capacityValueLabel, snowLevelValueLabel, itemImageLabel; //labelek a kapacitas, hoszint kirirasahoz es a befagyott targy kepenek megjelenitesehez

	public FieldPanel(IceField startingField) {
		this.field = startingField;

		//a layout beallitasa es GridBagConstraints az elemek felpakolasahoz
		setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		//alap betutipus a feliratoknak
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

	    //a kapacitast kiiro label (pl.: 3/4 2/?)
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

	    //a hó szintet kiiro label (pl.: 3)
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

	    //A panel, amiben megjelenik a befagyott targy
	    itemImageLabel = new JLabel();
	    //itemImageLabel.setBorder(BorderFactory.createLineBorder(Color.black));
	    c.weightx = 0.7;
		c.weighty = 1.0f/3.0f;
		c.gridx = 1;
	    c.gridy = 2;
	    add(itemImageLabel, c);


	}

	/**
	 * Beallitja az IceField-et, aminek az adatait meg kell jeleniteni
	 * @param field A beï¿½llï¿½tandï¿½ IceField
	 */
	public void setField(IceField field) {
		this.field.removeFieldView(this);
		this.field = field;
		this.field.addFieldView(this);
		Update();
	}

	/**
	 * Frissiti az eltorolt IceField atadait megjelenito mezoket.
	 */
	@Override
	public void Update() {
		if(field == null)
			return;

		itemImageLabel.setIcon(null);

		//a mezon allo entitasok szama/kapacitas (? ha meg nem ismert a kapacitas)
		String capacityText = Integer.toString(field.GetNumberOfEntities()).concat("/");
		int cap = field.GetCapacity();
		if(cap == 0 || field.isCapacityRevealed())
			capacityText = capacityText.concat(Integer.toString(cap));
		else
			capacityText = capacityText.concat("?");
		capacityValueLabel.setText(capacityText);

		//a hï¿½szint
		snowLevelValueLabel.setText(Integer.toString(field.getSnowLevel()));

		//a befagyott targy kepe, ha nincs ho a mezon
		if(field.getSnowLevel() == 0)
			itemImageLabel.setIcon(new ImageIcon(field.GetItem().GetView().GetImage()));

		revalidate();
	}

}
