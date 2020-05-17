package proto;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FieldPanel extends JPanel implements Updatable {
	
	IceField field;
	JLabel capacityValueLabel, snowLevelValueLabel;
	JPanel itemPanel;
	
	public FieldPanel() {
		setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		Font defaultFont = new Font("Arial", Font.PLAIN, 25);
		
		JLabel capacityLabel = new JLabel("Capacity:");
		capacityLabel.setHorizontalAlignment(JLabel.RIGHT);
		capacityLabel.setFont(defaultFont);
	    c.weightx = 0.3;
		c.weighty = 1.0f/3.0f;
		c.gridx = 0;
	    c.gridy = 0;
	    add(capacityLabel, c);
		
	    capacityValueLabel = new JLabel("-");
	    capacityValueLabel.setHorizontalAlignment(JLabel.CENTER);
	    capacityValueLabel.setFont(defaultFont);
	    c.weightx = 0.7;
		c.weighty = 1.0f/3.0f;
		c.gridx = 1;
	    c.gridy = 0;
	    add(capacityValueLabel, c);
	    
	    JLabel snowLevelLabel = new JLabel("Snow level:");
	    snowLevelLabel.setHorizontalAlignment(JLabel.RIGHT);
	    snowLevelLabel.setFont(defaultFont);
	    c.weightx = 0.3;
		c.weighty = 1.0f/3.0f;
		c.gridx = 0;
	    c.gridy = 1;
	    add(snowLevelLabel, c);
	    
	    snowLevelValueLabel = new JLabel("-");
	    snowLevelValueLabel.setHorizontalAlignment(JLabel.CENTER);
	    snowLevelValueLabel.setFont(defaultFont);
	    c.weightx = 0.7;
		c.weighty = 1.0f/3.0f;
		c.gridx = 1;
	    c.gridy = 1;
	    add(snowLevelValueLabel, c);
	    
	    JLabel itemLabel = new JLabel("Item:");
	    itemLabel.setHorizontalAlignment(JLabel.RIGHT);
	    itemLabel.setFont(defaultFont);
	    c.weightx = 0.3;
		c.weighty = 1.0f/3.0f;
		c.gridx = 0;
	    c.gridy = 2;
	    add(itemLabel, c);
	    
	    itemPanel = new JPanel();
	    itemPanel.setBorder(BorderFactory.createLineBorder(Color.black));
	    c.weightx = 0.7;
		c.weighty = 1.0f/3.0f;
		c.gridx = 1;
	    c.gridy = 2;
	    //c.insets = new Insets(30,120,30,120);
	    add(itemPanel, c);
	    
	    
	}

	public void setField(IceField field) {
		this.field = field;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
