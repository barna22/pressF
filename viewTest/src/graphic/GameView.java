package graphic;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * A j�gt�bl�kat �s a j�t�kos, illetve j�gt�bla panel
 */
public class GameView extends JPanel implements Updatable, KeyListener {
	private Game game;//a game, amit megjelen�t
	private List<FieldView> fieldViews = new ArrayList<FieldView>();//a j�gt�bl�k n�zetei
	private int rows, columns;//sorok, oszlopok
	public static GameView instance;//a p�ld�ny
	private JPanel tablePanel;//a t�bl�zat, amiben a j�gt�bl�k vannak
	private FieldPanel fieldPanel;//a j�gt�bla panel
	private PlayerPanel playerPanel;//a j�t�kos panel

	/**
	 * elk�sz�ti a p�ld�nyt �s be�ll�tja a j�t�kos panelt
	 * @param rows sorok
	 * @param columns oszlopok
	 * @param game a j�t�k
	 */
	public static void init(int rows, int columns, Game game) {
		instance = new GameView(rows, columns, game);
		instance.playerPanel.setPlayer(game.GetActivePlayer());
	}

	/**
	 * @param rows sorok
	 * @param columns oszlopok
	 * @param game a j�t�k
	 */
	private GameView(int rows, int columns, Game game) {
		super();
		MainWindow.instance.setFocusable(true);
		MainWindow.instance.addKeyListener(this);
		this.game = game;
		this.rows = rows;
		this.columns = columns;

		//layout �s gridbagconstraints az elemek felpakol�s�hoz
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		//a j�gt�bl�k t�rol�ja
		tablePanel = new JPanel();
		tablePanel.setLayout(new GridLayout(rows, columns));
		c.weightx = 1.7;
		c.gridheight = 2;
		c.gridx = 0;
		c.gridy = 0;
		add(tablePanel, c);

		//a j�gt�bla panel
		fieldPanel = new FieldPanel(game.getField(0));
		c.weightx = 0.3;
		c.weighty = 0.3;
		c.gridheight = 1;
		c.gridx = 1;
		c.gridy = 1;
		add(fieldPanel, c);

		//a j�t�kos panel
		playerPanel = new PlayerPanel();
		c.weightx = 0.3;
		c.weighty = 0.7;
		c.gridheight = 1;
		c.gridx = 1;
		c.gridy = 0;
		add(playerPanel, c);

		this.initialize();
	}

	/**
	 * felt�lti a j�gt�bl�k t�rol�j�t
	 */
	private void initialize() {
		for (int i = 0; i < rows * columns; i++) {
			FieldView fieldView = new FieldView(game.getField(i));
			fieldViews.add(fieldView);
			tablePanel.add(fieldView);
			game.getField(i).addFieldView(fieldView);
		}
	}

	/**
	 * Vihar anim�ci�ja, minden field elfeh�redik egy id�re
	 */
	public void AnimateStorm() {
		stormHappening = true;
		for (FieldView fieldView: fieldViews)
			fieldView.Update();
		Timer timer = new Timer(1000, new TimerActionListener());
		timer.setRepeats(false);
		timer.start();

	}


	final class TimerActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			stormHappening = false;
			for (FieldView fieldView: fieldViews)
				fieldView.Update();
		}

	}


	/**
	 * @return a j�gt�bla panel
	 */
	public FieldPanel getFieldPanel() {
		return fieldPanel;
	}

	/**
	 * @return a j�tkos panel
	 */
	public PlayerPanel getPlayerPanel() {
		return playerPanel;
	}

	@Override
	public void Update() {
		gameOver();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
	 *A billenty�lenyom�sok esem�nykezel�je
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// Akt�v j�t�kos mozgat�sa
		switch (e.getKeyCode()) {
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

		switch (e.getKeyChar()) {
		// K�pess�ghaszn�lat
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
		// �s�s
		case 'k':
			game.GetActivePlayer().Dig();
			break;
		// Eszk�z felszed�se
		case 'l':
			game.GetActivePlayer().PickUpItem();
			break;
		case 'm':
			game.GetActivePlayer().skipTurn();
			break;
		}

		playerPanel.Update();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	// J�t�k v�ge �zenet, vissza a f�men�be.
	public void gameOver() {
		if (game.getState().equals("win"))
			JOptionPane.showMessageDialog(MainWindow.instance, "Victory!\n" + "The game will return to the main menu!");
		else
			JOptionPane.showMessageDialog(MainWindow.instance, "Defeat!\n" + "The game will return to the main menu!");
		MainWindow.main(null);
	}
}
