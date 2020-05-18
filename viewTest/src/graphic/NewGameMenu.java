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

public class NewGameMenu extends JPanel {

	public static NewGameMenu instance;
	
	public static void init() {
		instance = new NewGameMenu();
	}
	
	private NewGameMenu() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		Font defaultFont = new Font("Arial", Font.PLAIN, 25);
		Insets defaultInsets = new Insets(30,30,30,30);
		c.insets = defaultInsets;
		
		
		JLabel eskimoLabel = new JLabel("Eszkimók:");
		eskimoLabel.setHorizontalAlignment(JLabel.CENTER);
		eskimoLabel.setFont(defaultFont);
		c.weightx = 0.25;
		c.weighty = 0.2;
		c.gridx = 0;
	    c.gridy = 0;
	    add(eskimoLabel, c);
	    
	    JTextField eskimoField = new JTextField("3");
	    eskimoField.setHorizontalAlignment(JTextField.CENTER);
	    eskimoField.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
	    c.gridx = 1;
	    c.gridy = 0;
	    add(eskimoField, c);
	    
	    JLabel researcherLabel = new JLabel("Kutatók:");
	    researcherLabel.setHorizontalAlignment(JLabel.CENTER);
	    researcherLabel.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
		c.gridx = 0;
	    c.gridy = 1;
	    add(researcherLabel, c);
	    
	    JTextField researcherField = new JTextField("3");
	    researcherField.setHorizontalAlignment(JTextField.CENTER);
	    researcherField.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
	    c.gridx = 1;
	    c.gridy = 1;
	    add(researcherField, c);
	 
	    JLabel icebearLabel = new JLabel("Jegesmedvék:");
	    icebearLabel.setHorizontalAlignment(JLabel.CENTER);
	    icebearLabel.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
		c.gridx = 0;
	    c.gridy = 2;
	    add(icebearLabel, c);
	    
	    JTextField icebearField = new JTextField("2");
	    icebearField.setHorizontalAlignment(JTextField.CENTER);
	    icebearField.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
	    c.gridx = 1;
	    c.gridy = 2;
	    add(icebearField, c);
	    
	    JLabel rowLabel = new JLabel("Sorok:");
	    rowLabel.setHorizontalAlignment(JLabel.CENTER);
	    rowLabel.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
		c.gridx = 2;
	    c.gridy = 1;
	    add(rowLabel, c);
	    
	    JTextField rowField = new JTextField("5");
	    rowField.setHorizontalAlignment(JTextField.CENTER);
	    rowField.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
	    c.gridx = 3;
	    c.gridy = 1;
	    add(rowField, c);
	    
	    JLabel colLabel = new JLabel("Oszlopok:");
	    colLabel.setHorizontalAlignment(JLabel.CENTER);
	    colLabel.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
		c.gridx = 2;
	    c.gridy = 2;
	    add(colLabel, c);
	    
	    JTextField colField = new JTextField("5");
	    colField.setHorizontalAlignment(JTextField.CENTER);
	    colField.setFont(defaultFont);
	    c.weightx = 0.25;
		c.weighty = 0.2;
	    c.gridx = 3;
	    c.gridy = 2;
	    add(colField, c);

	    Font buttonFont = new Font("Arial", Font.PLAIN, 40);
	    Insets buttonInsets = new Insets(30,30,30,30);// padding
	    
	    JButton backButton = new JButton("Vissza");
	    backButton.setFont(buttonFont);
	    c.weightx = 0.5;
		c.weighty = 0.1;
	    c.gridwidth = 2;
	    c.gridx = 0;
	    c.gridy = 3;
	    c.insets = buttonInsets; 
	    add(backButton, c);
	    
	    backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainWindow.instance.SetWindowPanel(MainMenu.instance);
			}
	    });
	    
	    JButton startButton = new JButton("Start");
	    startButton.setFont(buttonFont);
	    c.weightx = 0.5;
		c.weighty = 0.1;
	    c.gridwidth = 2;
	    c.gridx = 2;
	    c.gridy = 3;
	    c.insets = buttonInsets;
	    add(startButton, c);
	    
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
