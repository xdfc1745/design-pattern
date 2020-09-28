package drawer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import command.MacroCommand;

public class DrawConvas extends Canvas implements Drawable{
	private Color color;
	private int radius;
	private MacroCommand history;
	public DrawConvas (int width, int height, MacroCommand history) {
		setSize(width, height);
		setBackground(Color.white);
		this.history = history;
		init();
	}
	public void paint(Graphics g) {
		history.execute();
	}

	@Override
	public void init() {
		color = Color.red;
		radius = 6;
	}

	public void draw(int x, int y) {
		Graphics g = getGraphics();
		g.setColor(color);
		g.fillOval(x = x-radius, y-radius, radius*2, radius*2);
	}
	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		this.color = color;
	}
} 
