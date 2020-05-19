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
 * Bek�ri az �j j�t�k param�tereit textfield-ekbe, majd a start gombbal el lehet ind�tani a j�t�kot
 */
public class NewGameMenu extends JPanel {

	public static NewGameMenu instance;
	
	/**
	 * elk�sz�ti a p�ld�nyt
	 */
	public static void init() {
		instance = new NewGameMenu();
	}
	
	private NewGameMenu() {
		
		//layout �s gridbagconstraints az elemek felpakol�s�hoz
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		//alap bet�t�pus
		Font defaultFont = new Font("Arial", Font.PLAIN, 25);
		//marg�?
		Insets defaultInsets = new Insets(30,30,30,30);
		c.insets = defaultInsets;
		
		//az Eszkim�k felirat
		JLabel eskimoLabel = new JLabel("Eszkim�k:");
		eskimoLabel.setHorizontalAlignment(JLabel.CENTER);
		eskimoLabel.setFont(defaultFont);
		c.weightx = 0.25;
		c.weighty = 0.2;
		c.gridx = 0;
	    c.gridy = 0;
	    add(eskimoLabel, c);
	    
	    //textfield az eszkim�k sz�m�nak megad�s�hoz
	    JTextField eskimoField = new JTextField("3");
	    eskimoField.setHorizontalAlignment(JTextField.CENTER);
	    eskimoField.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
	    c.gridx = 1;
	    c.gridy = 0;
	    add(eskimoField, c);
	    
	    //a Kutat�k felirat
	    JLabel researcherLabel = new JLabel("Kutat�k:");
	    researcherLabel.setHorizontalAlignment(JLabel.CENTER);
	    researcherLabel.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
		c.gridx = 0;
	    c.gridy = 1;
	    add(researcherLabel, c);
	    
	    //textfield az kutat�k sz�m�nak megad�s�hoz
	    JTextField researcherField = new JTextField("3");
	    researcherField.setHorizontalAlignment(JTextField.CENTER);
	    researcherField.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
	    c.gridx = 1;
	    c.gridy = 1;
	    add(researcherField, c);
	 
	    //a Jegesmedv�k felirat
	    JLabel icebearLabel = new JLabel("Jegesmedv�k:");
	    icebearLabel.setHorizontalAlignment(JLabel.CENTER);
	    icebearLabel.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
		c.gridx = 0;
	    c.gridy = 2;
	    add(icebearLabel, c);
	    
	    //textfield a jegesmedv�k sz�m�nak megad�s�hoz
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
	    
	  //textfield a sorok sz�m�nak megad�s�hoz
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
	    
	    //textfield az oszlopok sz�m�nak megad�s�hoz
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
	    
	    //visszal�p a f�men�be
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
	    
	    //ind�t egy j�t�kot a textfield-ekb�l vett param�terekkel
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
