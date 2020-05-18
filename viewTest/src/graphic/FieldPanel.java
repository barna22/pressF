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
 * Megjeleníti a kijelölt IceField adatait.
 */
public class FieldPanel extends JPanel implements Updatable {
	
	IceField field;//a field, aminek az adatait kiírja
	JLabel capacityValueLabel, snowLevelValueLabel, itemImageLabel; //labelek a kapacitás, hószint kiírásához és a befagyott tárgy képének megjelenítéséhez
	
	public FieldPanel(IceField startingField) {
		this.field = startingField;
		
		//a layout beállítása és GridBagConstraints az elemek felpakolásához
		setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		//alap betûtípus a feliratoknak
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
		
	    //a kapacitást kiíró label (pl.: 3/4 2/?)
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
	    
	    //a hószintet kiíró label (pl.: 3)
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
	    
	    //A panel, amiben megjelenik a nefagyott tárgy
	    itemImageLabel = new JLabel();
	    itemImageLabel.setBorder(BorderFactory.createLineBorder(Color.black));
	    c.weightx = 0.7;
		c.weighty = 1.0f/3.0f;
		c.gridx = 1;
	    c.gridy = 2;
	    //c.fill = GridBagConstraints.VERTICAL;
	    //c.insets = new Insets(30,80,30,80);
	    add(itemImageLabel, c);
	    
	    
	}

	/**
	 * Beállítja az IceField-et, aminek az adatait meg kell jeleníteni
	 * @param field A beállítandó IceField
	 */
	public void setField(IceField field) {
		this.field.removeFieldView(this);
		this.field = field;
		this.field.addFieldView(this);
		Update();
	}
	
	/**
	 * Frissíti az eltárolt IceField atadait megjelenító mezõket.
	 */
	@Override
	public void Update() {
		if(field == null)
			return;
		
		//a mezõn álló entitások száma/kapacitás (? ha még nem ismert a kapacitás)
		String capacityText = Integer.toString(field.GetNumberOfEntities()).concat("/");
		capacityText.concat(field.isCapacityRevealed() ? Integer.toString(field.GetCapacity()) : "?");
		capacityValueLabel.setText(capacityText);
		
		//a hószint
		snowLevelValueLabel.setText(Integer.toString(field.getSnowLevel()));
		
		//a befagyott tárgy képe
		itemImageLabel.setIcon(new ImageIcon(field.GetItem().GetView().GetImage()));
	}
	
}
