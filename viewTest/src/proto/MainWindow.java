package proto;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame
{
	public static MainWindow instance;
	private MainWindow(){
		super("Alkalmazás neve");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(1000, 700));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		instance = new MainWindow();
		
		/*Game game = new Game();
		game.init(5, 5, 2, 2, 1);
		JPanel gameView = new GameView(5, 5, game);*/
		
		MainMenu.init();
		NewGameMenu.init();
		instance.setContentPane(MainMenu.instance);
		
		instance.pack();
	}
	
	public void SetWindowPanel(JPanel panel) {
		instance.setContentPane(panel);
		instance.pack();
	}
	
}