package proto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel{
	
	public static MainMenu instance;
	
	private MainMenu(){
		
		setLayout(null);
		
		JButton newGameButton = new JButton("Új játék");
		newGameButton.setBounds(400, 200, 200, 50);
		add(newGameButton);
		
		/**
		 * Megnyitja az új játék menüjét
		 */
		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainWindow.instance.SetWindowPanel(NewGameMenu.instance);
			}
	    });
		
		JButton exitButton = new JButton("Kilépés");
		exitButton.setBounds(400, 300, 200, 50);
		add(exitButton);
		
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
			}          
	    });
	}
	
	public static void init() {
		instance = new MainMenu();
	}
}

