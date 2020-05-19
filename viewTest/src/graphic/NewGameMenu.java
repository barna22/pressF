package graphic;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Bekéri az új játék paramétereit textfield-ekbe, majd a start gombbal el lehet indítani a játékot
 */
public class NewGameMenu extends JPanel {

	public static NewGameMenu instance;
	
	/**
	 * elkészíti a példányt
	 */
	public static void init() {
		instance = new NewGameMenu();
	}
	
	private NewGameMenu() {
		
		//layout és gridbagconstraints az elemek felpakolásához
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		//alap betûtípus
		Font defaultFont = new Font("Arial", Font.PLAIN, 25);
		//margó?
		Insets defaultInsets = new Insets(30,30,30,30);
		c.insets = defaultInsets;
		
		//az Eszkimók felirat
		JLabel eskimoLabel = new JLabel("Eszkimók:");
		eskimoLabel.setHorizontalAlignment(JLabel.CENTER);
		eskimoLabel.setFont(defaultFont);
		c.weightx = 0.25;
		c.weighty = 0.2;
		c.gridx = 0;
	    c.gridy = 0;
	    add(eskimoLabel, c);
	    
	    //textfield az eszkimók számának megadásához
	    JTextField eskimoField = new JTextField("3");
	    eskimoField.setHorizontalAlignment(JTextField.CENTER);
	    eskimoField.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
	    c.gridx = 1;
	    c.gridy = 0;
	    add(eskimoField, c);
	    
	    //a Kutatók felirat
	    JLabel researcherLabel = new JLabel("Kutatók:");
	    researcherLabel.setHorizontalAlignment(JLabel.CENTER);
	    researcherLabel.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
		c.gridx = 0;
	    c.gridy = 1;
	    add(researcherLabel, c);
	    
	    //textfield az kutatók számának megadásához
	    JTextField researcherField = new JTextField("3");
	    researcherField.setHorizontalAlignment(JTextField.CENTER);
	    researcherField.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
	    c.gridx = 1;
	    c.gridy = 1;
	    add(researcherField, c);
	 
	    //a Jegesmedvék felirat
	    JLabel icebearLabel = new JLabel("Jegesmedvék:");
	    icebearLabel.setHorizontalAlignment(JLabel.CENTER);
	    icebearLabel.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
		c.gridx = 0;
	    c.gridy = 2;
	    add(icebearLabel, c);
	    
	    //textfield a jegesmedvék számának megadásához
	    JTextField icebearField = new JTextField("2");
	    icebearField.setHorizontalAlignment(JTextField.CENTER);
	    icebearField.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
	    c.gridx = 1;
	    c.gridy = 2;
	    add(icebearField, c);
	    
	    //a Sorok felirat
	    JLabel rowLabel = new JLabel("Sorok:");
	    rowLabel.setHorizontalAlignment(JLabel.CENTER);
	    rowLabel.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
		c.gridx = 2;
	    c.gridy = 1;
	    add(rowLabel, c);
	    
	  //textfield a sorok számának megadásához
	    JTextField rowField = new JTextField("5");
	    rowField.setHorizontalAlignment(JTextField.CENTER);
	    rowField.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
	    c.gridx = 3;
	    c.gridy = 1;
	    add(rowField, c);
	    
	    //az Oszlopok felirat
	    JLabel colLabel = new JLabel("Oszlopok:");
	    colLabel.setHorizontalAlignment(JLabel.CENTER);
	    colLabel.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
		c.gridx = 2;
	    c.gridy = 2;
	    add(colLabel, c);
	    
	    //textfield az oszlopok számának megadásához
	    JTextField colField = new JTextField("5");
	    colField.setHorizontalAlignment(JTextField.CENTER);
	    colField.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
	    c.gridx = 3;
	    c.gridy = 2;
	    add(colField, c);

	    Font buttonFont = new Font("Arial", Font.PLAIN, 40);
	    
	    //Vissza gomb
	    JButton backButton = new JButton("Vissza");
	    backButton.setFont(buttonFont);
	    c.weightx = 0.5;
		c.weighty = 0.1;
	    c.gridwidth = 2;
	    c.gridx = 0;
	    c.gridy = 3;
	    add(backButton, c);
	    
	    //visszalép a fõmenübe
	    backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainWindow.instance.SetWindowPanel(MainMenu.instance);
			}
	    });
	    
	    //Start gomb
	    JButton startButton = new JButton("Start");
	    startButton.setFont(buttonFont);
	    c.weightx = 0.5;
		c.weighty = 0.1;
	    c.gridwidth = 2;
	    c.gridx = 2;
	    c.gridy = 3;
	    add(startButton, c);
	    
	    //indít egy játékot a textfield-ekbõl vett paraméterekkel
	    startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row, col;
				row = Integer.parseInt(rowField.getText());
				col = Integer.parseInt(colField.getText());
				
				Game game = new Game();
				game.init(
						row, col,
						Integer.parseInt(eskimoField.getText()),
						Integer.parseInt(researcherField.getText()),
						Integer.parseInt(icebearField.getText()));
				GameView.init(row, col, game);
				MainWindow.instance.SetWindowPanel(GameView.instance);
			}
	    });
	}
	
	
}
