package proto;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Megjeleníti az aktív játékos adatait.
 */
public class PlayerPanel extends JPanel implements Updatable {

	Player player;//a játékos, akinek az adatait megjeleníti
	JLabel playerNameLabel, actionsValueLabel, healthValueLabel;//labelek a játékos nevének, hátralévõ akciói számának és testhõjének kiírásához
	ArrayList<JLabel> itemLabels = new ArrayList<JLabel>();//A birtokolt tárgyak ezekben a labelekben jelennek meg az inventoryban
	
	public PlayerPanel() {
		//a layout beállítása és GridBagConstraints az elemek felpakolásához
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		//alap betûtípus a feliratoknak
		Font defaultFont = new Font("Arial", Font.PLAIN, 25);
		
		//Az Active player felirat
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
		
	    //a játékos neve
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
	    
	    //Az Actions felirat
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
	    
	    //A hátralevõ akciók száma
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
	    
	    //A Health (testhõ) felirat
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
	    
	    //A testhõ értéke
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
	    
	    //Az Inventory felirat
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
	    
	    //A játékos táskája
	    JPanel inventoryPanel = new JPanel();
	    inventoryPanel.setLayout(new GridLayout(2, 5));
	    c.weightx = 2;
		c.weighty = 3;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.gridx = 1;
	    c.gridy = 6;
	    add(inventoryPanel, c);
	    
	    //A táskában levõ Labelek, amik megjelenítik a tárgyakat
	    for(int i = 0; i < 10; i++) {
	    	JLabel itemPanel = new JLabel();
		    itemPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		    inventoryPanel.add(itemPanel);
	    }
		
		//helykitöltõ panelek a 2 sarokba a többi elem helyének igazításához
		c.weightx = 1;
		c.weighty = 2.2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 0;
	    c.gridy = 0;
	    add(new JPanel(),c);
	    c.gridx = 3;
	    c.gridy = 7;
	    add(new JPanel(),c);
	    
	}
	
	/**
	 * Beállítja a kapott játékost megjelenítendõként
	 * @param p Az új játékos
	 */
	public void setPlayer(Player p) {
		player = p;
	}
	
	/**
	 * Frissíti az eltárolt játékos atadait megjelenító mezõket.
	 */
	@Override
	public void update() {//playerNameLabel, actionsValueLabel, healthValueLabel

		if(player == null)
			return;
		
		//az aktív játékos neve
		playerNameLabel.setText(player.GetName());
		
		//a hátralévõ akciói
		actionsValueLabel.setText(Integer.toString(player.GetRemaningActions()).concat("/4"));
		
		//a játékos testhõje
		healthValueLabel.setText(Integer.toString(player.GetTemp()).concat("/").concat(Integer.toString(player.GetMaxTemperature())));
		
		//TODO megjeleníteni a játékos tárgyait az inventoryban.
	}

}
