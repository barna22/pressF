package graphic;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GameView extends JPanel implements Updatable, KeyListener{
	private Game game;
	private List<FieldView> fieldViews = new ArrayList<FieldView>();
	private int rows, columns;
	public static GameView instance;
	private JPanel tablePanel;
	private FieldPanel fieldPanel;
	private PlayerPanel playerPanel;
	
	public static void init(int rows, int columns, Game game) {
		instance = new GameView(rows, columns, game);
	}
	
	
	
	private GameView(int rows, int columns, Game game) {
		super();
		MainWindow.instance.setFocusable(true);
		MainWindow.instance.addKeyListener(this);
		this.game = game;
		this.rows = rows;
		this.columns = columns;
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		tablePanel = new JPanel();
		tablePanel.setLayout(new GridLayout(rows, columns));
		c.weightx = 1.7;
	    c.gridheight = 2;
	    c.gridx = 0;
	    c.gridy = 0;
		add(tablePanel, c);
		
		fieldPanel = new FieldPanel(game.getField(0));
		c.weightx = 0.3;
		c.weighty = 0.3;
	    c.gridheight = 1;
	    c.gridx = 1;
	    c.gridy = 1;
		add(fieldPanel, c);
		
		playerPanel = new PlayerPanel();
		c.weightx = 0.3;
		c.weighty = 0.7;
	    c.gridheight = 1;
	    c.gridx = 1;
	    c.gridy = 0;
		add(playerPanel, c);
		
		this.initialize();
	}
	
	private void initialize() {
		for(int i = 0; i < rows * columns; i++) {
			FieldView fieldView = new FieldView(game.getField(i));
			fieldViews.add(fieldView);
			tablePanel.add(fieldView);
			game.getField(i).addFieldView(fieldView);
		}
	}

	public FieldPanel getFieldPanel() {
		return fieldPanel;
	}
	
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
	}



	@Override
	public void keyPressed(KeyEvent e) {
		//Aktív játékos mozgatása
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
			game.GetActivePlayer().Move(Direction.UP);
			break;
		case KeyEvent.VK_DOWN:
			game.GetActivePlayer().Move(Direction.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			game.GetActivePlayer().Move(Direction.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			game.GetActivePlayer().Move(Direction.RIGHT);
			break;
		}
		System.out.println("key: " + e.getKeyCode());
		
		//Képességhasználat
		switch(e.getKeyChar()) {
		case 'w':
			game.GetActivePlayer().UseAbility(Direction.UP);
			break;
		case 'a':
			game.GetActivePlayer().UseAbility(Direction.LEFT);
			break;
		case 's':
			game.GetActivePlayer().UseAbility(Direction.DOWN);
			break;
		case 'd':
			game.GetActivePlayer().UseAbility(Direction.RIGHT);
			break;
		}
	}



	@Override
	public void keyReleased(KeyEvent e) {
	}
}
