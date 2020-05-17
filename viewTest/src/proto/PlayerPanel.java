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
 * Megjelen�ti az akt�v j�t�kos adatait.
 */
public class PlayerPanel extends JPanel implements Updatable {

	Player player;//a j�t�kos, akinek az adatait megjelen�ti
	JLabel playerNameLabel, actionsValueLabel, healthValueLabel;//labelek a j�t�kos nev�nek, h�tral�v� akci�i sz�m�nak �s testh�j�nek ki�r�s�hoz
	ArrayList<JLabel> itemLabels = new ArrayList<JLabel>();//A birtokolt t�rgyak ezekben a labelekben jelennek meg az inventoryban
	
	public PlayerPanel() {
		//a layout be�ll�t�sa �s GridBagConstraints az elemek felpakol�s�hoz
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		//alap bet�t�pus a feliratoknak
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
		
	    //a j�t�kos neve
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
	    
	    //A h�tralev� akci�k sz�ma
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
	    
	    //A Health (testh�) felirat
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
	    
	    //A testh� �rt�ke
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
	    
	    //A j�t�kos t�sk�ja
	    JPanel inventoryPanel = new JPanel();
	    inventoryPanel.setLayout(new GridLayout(2, 5));
	    c.weightx = 2;
		c.weighty = 3;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.gridx = 1;
	    c.gridy = 6;
	    add(inventoryPanel, c);
	    
	    //A t�sk�ban lev� Labelek, amik megjelen�tik a t�rgyakat
	    for(int i = 0; i < 10; i++) {
	    	JLabel itemPanel = new JLabel();
		    itemPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		    inventoryPanel.add(itemPanel);
	    }
		
		//helykit�lt� panelek a 2 sarokba a t�bbi elem hely�nek igaz�t�s�hoz
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
	 * Be�ll�tja a kapott j�t�kost megjelen�tend�k�nt
	 * @param p Az �j j�t�kos
	 */
	public void setPlayer(Player p) {
		player = p;
	}
	
	/**
	 * Friss�ti az elt�rolt j�t�kos atadait megjelen�t� mez�ket.
	 */
	@Override
	public void update() {//playerNameLabel, actionsValueLabel, healthValueLabel

		if(player == null)
			return;
		
		//az akt�v j�t�kos neve
		playerNameLabel.setText(player.GetName());
		
		//a h�tral�v� akci�i
		actionsValueLabel.setText(Integer.toString(player.GetRemaningActions()).concat("/4"));
		
		//a j�t�kos testh�je
		healthValueLabel.setText(Integer.toString(player.GetTemp()).concat("/").concat(Integer.toString(player.GetMaxTemperature())));
		
		//TODO megjelen�teni a j�t�kos t�rgyait az inventoryban.
	}

}
