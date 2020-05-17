package proto;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class FieldPanel extends JPanel implements Updatable {
	
	IceField field;
	
	public FieldPanel() {
		setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(new GridBagLayout());
		
		
		
	}

	public void setField(IceField field) {
		this.field = field;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
