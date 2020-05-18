package graphic;

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
		if(instance != null) {
			instance.setVisible(false);
			instance.dispose();
		}
		instance = new MainWindow();
		
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