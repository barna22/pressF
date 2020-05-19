package graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * A f�men�
 */
public class MainMenu extends JPanel{
	
	public static MainMenu instance;
	
	private MainMenu(){
		
		setLayout(null);
		
		//az �j j�t�k gomb
		JButton newGameButton = new JButton("�j j�t�k");
		newGameButton.setBounds(400, 200, 200, 50);
		add(newGameButton);
		
		
		//Megnyitja az �j j�t�k men�j�t
		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainWindow.instance.SetWindowPanel(NewGameMenu.instance);
			}
	    });
		
		//kil�p�s gomb
		JButton exitButton = new JButton("Kil�p�s");
		exitButton.setBounds(400, 300, 200, 50);
		add(exitButton);
		
		//le�ll�tja a programot
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
			}          
	    });
	}
	
	/**
	 * Elk�sz�ti a p�ld�nyt.
	 */
	public static void init() {
		instance = new MainMenu();
	}
}

