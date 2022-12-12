package entity;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;
import view.Game;

public class Ball {
    
    
//	private static final int DIAMETER = 30;
        private static final int Y = 330;
//	private int x = 0;
//	private int y = 0;
//	private int xa = 1;
//	private int ya = 1;
//        private Color color;
//	private Game game;
    
  
    private int posX = 20;
    private int posY = 20;
    private final int margen = 25;
    private final int ballWidth = 32;
    private final int ballHeight=32;
    int direccionX = 1;
    int direccionY = 1;
    private JPanel panel;
    private Color color;

	public Ball(JPanel panel, int posX, int posY, Color color) {
		this.panel = panel;
                this.posX = posX;
                this.posY = posY;
                this.color = color;
	}

	public void move() {
		 if (posX + direccionX-margen< 0)
			direccionX = 1;
		if (posX + direccionX +margen> panel.getWidth() - ballWidth)
			direccionX = -1;
		if (posY + direccionY-margen < 0)
			direccionY = 1;
		if (posY + direccionY+margen > panel.getHeight()-ballHeight)
			direccionY = -1;
		
		posX = posX + direccionX;
		posY = posY + direccionY;
	}

	public void collision(Ball ball) {
            if (ball.getBounds().intersects(this.getBounds())){
			direccionY *= -1;
			posY = this.getTopY()- this.ballHeight;
                        
            
            }
	}

	public void paint(Graphics2D g) {
            g.setColor(this.color);
		g.fillOval(posX, posY, this.ballWidth,this.ballHeight);
                g.setColor(this.color);
                g.drawOval(posX, posY, ballHeight, ballWidth);
                 

	}
	
	public Rectangle getBounds() {
		return new Rectangle(posX, posY, this.ballWidth, this.ballHeight);
	}
        
        public int getTopY() {
		return Y - this.ballWidth;
	}
}