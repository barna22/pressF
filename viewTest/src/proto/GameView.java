package proto;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GameView extends JPanel{
	private Game game;
	private List<FieldView> fieldViews = new ArrayList<FieldView>();
	private int rows, columns;
	
	public GameView(int rows, int columns, Game game) {
		super();
		this.game = game;
		this.rows = rows;
		this.columns = columns;
		this.setLayout(new GridLayout(rows, columns));
		this.initialize();
	}
	
	private void initialize() {
		for(int i = 0; i < rows * columns; i++) {
			FieldView fieldView = new FieldView(game.getField(i));
			fieldViews.add(fieldView);
			this.add(fieldView);
			game.getField(i).addFieldView(fieldView);
		}
	}
}
