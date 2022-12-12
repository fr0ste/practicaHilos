package entity;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import view.Game;

public class Ball {
	private static final int DIAMETER = 30;
        private static final int Y = 330;
	private int x = 0;
	private int y = 0;
	private int xa = 1;
	private int ya = 1;
        private Color color;
	private Game game;

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

    public int getXa() {
        return xa;
    }

    public void setXa(int xa) {
        this.xa = xa;
    }

    public int getYa() {
        return ya;
    }

    public void setYa(int ya) {
        this.ya = ya;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
        

	public Ball(Game game, int x, int y, Color color) {
		this.game= game;
                this.x = x;
                this.y = y;
                this.color = color;
	}

	public void move() {
		if (x + xa < 0)
			xa = 1;
		if (x + xa > game.getWidth() - DIAMETER)
			xa = -1;
		if (y + ya < 0)
			ya = 1;
		if (y + ya > game.getHeight() - DIAMETER)
			ya = -1;
		
		x = x + xa;
		y = y + ya;
	}

	public void collision(Ball ball) {
            if (ball.getBounds().intersects(this.getBounds())){
			ya *= -1;
			y = this.getTopY()- DIAMETER;
                        ball.setYa(ya*-1);
                        ball.setY(ball.getTopY());
            
            }
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
                g.setColor(this.color);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
        
        public int getTopY() {
		return Y - DIAMETER;
	}
}