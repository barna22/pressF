package proto;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel implements Updatable {

	public PlayerPanel() {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
