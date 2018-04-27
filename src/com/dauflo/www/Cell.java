package com.dauflo.www;

import java.awt.Color;
import java.awt.Graphics;

public class Cell {

	private boolean up, left, right, down, visited;

	private int x, y, size;

	public Cell(int x, int y, int size) {
		this.up = true;
		this.left = true;
		this.right = true;
		this.down = true;

		this.visited = false;

		this.x = x;
		this.y = y;
		this.size = size;
	}

	public void draw(Graphics g) {
		if (visited) {
			Color green = new Color(0, 255, 0, 100);
			g.setColor(green);
		} else {
			Color red = new Color(255, 0, 0, 100);
			g.setColor(red);
		}
		g.fillRect(MainFrame.width / size * x, MainFrame.height / size * y, MainFrame.width / size,
				MainFrame.height / size);

		g.setColor(Color.BLACK);

		// Top line
		if (up) {
			g.drawLine(MainFrame.width / size * x, MainFrame.height / size * y,
					MainFrame.width / size * x + MainFrame.width / size, MainFrame.height / size * y);
		}
		// Bottom line
		if (down) {
			g.drawLine(MainFrame.width / size * x, MainFrame.height / size * y + MainFrame.height / size - 1,
					MainFrame.width / size * x + MainFrame.width / size,
					MainFrame.height / size * y + MainFrame.height / size - 1);
		}
		// Left line
		if (left) {
			g.drawLine(MainFrame.width / size * x, MainFrame.height / size * y, MainFrame.width / size * x,
					MainFrame.height / size * y + MainFrame.height / size);
		}
		// Right line
		if (right) {
			g.drawLine(MainFrame.width / size * x + MainFrame.width / size - 1, MainFrame.height / size * y,
					MainFrame.width / size * x + MainFrame.width / size - 1,
					MainFrame.height / size * y + MainFrame.height / size - 1);
		}
	}

	public boolean isUp() {
		return up;
	}

	public void setUp() {
		this.up = false;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft() {
		this.left = false;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight() {
		this.right = false;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown() {
		this.down = false;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited() {
		this.visited = true;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}
