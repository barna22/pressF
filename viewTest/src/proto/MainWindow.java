package proto;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame
{

	public MainWindow(){
		super("Alkalmazás neve");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(480, 480));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		MainWindow mainWindow = new MainWindow();
		
		Game game = new Game();
		game.init(5, 5, 2, 2, 1);
		JPanel gameView = new GameView(5, 5, game);
		mainWindow.setContentPane(gameView);
		
		mainWindow.pack();
	}

}