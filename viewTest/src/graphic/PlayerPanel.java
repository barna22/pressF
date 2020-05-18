package graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	    	JLabel itemLabel = new JLabel();
	    	itemLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		    inventoryPanel.add(itemLabel);
		    itemLabel.addMouseListener(new MouseAdapter() {

		        public void mouseClicked(MouseEvent e) {
		        	JLabel label = (JLabel) e.getSource();
		        	if(label.getIcon() != null)
		        		player.UseItem(player.GetItems().get(itemLabels.indexOf(label)));
		        	Update();
		        }

		    });
		    itemLabels.add(itemLabel);
	    }
		
	    //Skip gomb
	    JButton skip = new JButton("Skip");
	    skip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.skipTurn();
				MainWindow.instance.SetWindowPanel(GameView.instance);
			}
	    });
	    
	    //Suicide gomb
	    JButton suicide = new JButton("Suicide");
	    suicide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.Die();
			}
	    });
	    
	    
	    //Gomb jobb alulra a játék feladásához
		c.weightx = 1;
		c.weighty = 2.2;
		c.gridwidth = 1;
		c.gridheight = 1;
	    c.gridx = 3;
	    c.gridy = 7;
	    add(suicide,c);
	    // Gomb a bal felsõ sarokba a kör skippeléséhez
	    c.gridx = 0;
	    c.gridy = 0;
	    add(skip,c);
	    
	}
	
	/**
	 * Létrehozza a kapcsolatot a megadott játékossal
	 * Ha be volt állítva eddig egy elõzõ, azzal bontja a kapcsolatot
	 * @param p Az új játékos
	 */
	public void setPlayer(Player p) {
		if(player != null) 
			player.RemovePlayerPanel();
			
		p.SetPlayerPanel(this);
		player = p;
		Update();
	}
	
	/**
	 * Frissíti az eltárolt játékos atadait megjelenító mezõket.
	 */
	@Override
	public void Update() {

		//inventory kiürítése
		for(JLabel label : itemLabels) 
			label.setIcon(null);
		
		if(player == null)
			return;
		
		//az aktív játékos neve
		playerNameLabel.setText(player.GetName());
		
		//a hátralévõ akciói
		actionsValueLabel.setText(Integer.toString(player.GetRemaningActions()).concat("/4"));
		
		//a játékos testhõje
		healthValueLabel.setText(Integer.toString(player.GetTemp()).concat("/").concat(Integer.toString(player.GetMaxTemperature())));
		
		//a játékos tárgyai az inventoryba
		ArrayList<Item> items = player.GetItems();
		int idx = 0;
		for( Item i : items) {
			itemLabels.get(idx).setIcon(new ImageIcon(i.GetView().GetImage()));
			idx++;
		}
	}

}
