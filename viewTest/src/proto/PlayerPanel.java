package proto;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel implements Updatable {

	JLabel playerNameLabel, actionsValueLabel, healthValueLabel;
	ArrayList<JPanel> itemPanels = new ArrayList<JPanel>();
	
	public PlayerPanel() {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		Font defaultFont = new Font("Arial", Font.PLAIN, 25);
		
		JLabel playerLabel = new JLabel("Active player:");
		playerLabel.setHorizontalAlignment(JLabel.CENTER);
		playerLabel.setFont(defaultFont);
	    c.weightx = 2;
		c.weighty = 1;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.gridx = 1;
	    c.gridy = 1;
	    add(playerLabel, c);
		
	    playerNameLabel = new JLabel("-");
	    playerNameLabel.setHorizontalAlignment(JLabel.CENTER);
	    playerNameLabel.setFont(defaultFont);
	    c.weightx = 2;
		c.weighty = 1;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.gridx = 1;
	    c.gridy = 2;
	    add(playerNameLabel, c);
	    
	    JLabel actionsLabel = new JLabel("Actions:");
	    actionsLabel.setHorizontalAlignment(JLabel.CENTER);
	    actionsLabel.setFont(defaultFont);
	    c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 1;
	    c.gridy = 3;
	    add(actionsLabel, c);
	    
	    actionsValueLabel = new JLabel("-");
	    actionsValueLabel.setHorizontalAlignment(JLabel.CENTER);
	    actionsValueLabel.setFont(defaultFont);
	    c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 2;
	    c.gridy = 3;
	    add(actionsValueLabel, c);
	    
	    JLabel healthLabel = new JLabel("Health:");
	    healthLabel.setHorizontalAlignment(JLabel.CENTER);
	    healthLabel.setFont(defaultFont);
	    c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 1;
	    c.gridy = 4;
	    add(healthLabel, c);
	    
	    healthValueLabel = new JLabel("-");
	    healthValueLabel.setHorizontalAlignment(JLabel.CENTER);
	    healthValueLabel.setFont(defaultFont);
	    c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 2;
	    c.gridy = 4;
	    add(healthValueLabel, c);
	    
	    JLabel inventoryLabel = new JLabel("Inventory");
	    inventoryLabel.setHorizontalAlignment(JLabel.CENTER);
	    inventoryLabel.setFont(defaultFont);
	    c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 1;
	    c.gridy = 5;
	    add(inventoryLabel, c);
	    
	    JPanel inventoryPanel = new JPanel();
	    inventoryPanel.setLayout(new GridLayout(2, 5));
	    c.weightx = 2;
		c.weighty = 3;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.gridx = 1;
	    c.gridy = 6;
	    add(inventoryPanel, c);
	    
	  
		//for(int j = 0; j < 2; j++)
		    for(int i = 0; i < 10; i++) {
		    	JPanel itemPanel = new JPanel();
			    itemPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			    inventoryPanel.add(itemPanel);
		    }
		
		//kitöltõ a 2 sarokba
		c.weightx = 1.5;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 0;
	    c.gridy = 0;
	    add(new JPanel(),c);
	    c.gridx = 3;
	    c.gridy = 7;
	    add(new JPanel(),c);
	    
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
