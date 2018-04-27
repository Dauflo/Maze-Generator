package com.dauflo.www;

import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;

public class Maze extends Component implements Runnable {

	private Cell[][] maze;
	public static final int mazeSize = 50;

	public Maze() {
		maze = new Cell[mazeSize][mazeSize];
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				maze[i][j] = new Cell(i, j, mazeSize);
			}
		}
		maze[0][0].setVisited();
		maze[0][0].setLeft();

		new Thread(this).start();
	}

	@Override
	public void paint(Graphics g) {

		for (Cell[] mazeLign : maze) {
			for (Cell cell : mazeLign) {
				cell.draw(g);
			}
		}
		repaint();
	}

	@Override
	public void run() {
		algo(0, 0);
		repaint();
		new Thread(this).stop();
	}

	private void algo(int x, int y) {
		int count = 0;
		ArrayList<Cell> unvisitedCellList = new ArrayList<Cell>();
		try {
			if (maze[x - 1][y].isVisited()) {
				count++;
			} else {
				unvisitedCellList.add(maze[x - 1][y]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			count++;
		}
		try {
			if (maze[x + 1][y].isVisited()) {
				count++;
			} else {
				unvisitedCellList.add(maze[x + 1][y]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			count++;
		}
		try {
			if (maze[x][y - 1].isVisited()) {
				count++;
			} else {
				unvisitedCellList.add(maze[x][y - 1]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			count++;
		}
		try {
			if (maze[x][y + 1].isVisited()) {
				count++;
			} else {
				unvisitedCellList.add(maze[x][y + 1]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			count++;
		}

		if (count == 4) {
			// Pop stack
		} else {
			count++;

			Cell nextCurrent = unvisitedCellList.get((int) (Math.random() * unvisitedCellList.size()));

			nextCurrent.setVisited();

			int nextX = nextCurrent.getX();
			int nextY = nextCurrent.getY();

			// Delete wall
			if (nextX == x) {
				if (nextY < y) {
					maze[x][y].setUp();
					maze[x][y - 1].setDown();
				} else {
					maze[x][y].setDown();
					maze[x][y + 1].setUp();
				}
			} else {
				if (nextX < x) {
					maze[x][y].setLeft();
					maze[x - 1][y].setRight();
				} else {
					maze[x][y].setRight();
					maze[x + 1][y].setLeft();
				}
			}
			repaint();
			// Push stack
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			algo(nextX, nextY);

			if (count != 4) {
				algo(x, y);
			}
			repaint();

		}
	}
}
