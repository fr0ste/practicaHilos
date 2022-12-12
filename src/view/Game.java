package view;

import entity.Ball;
import entity.Racquet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel {

	   public Ball ball = new Ball(this, 0,0, Color.BLUE);
           public Ball ball2 = new Ball(this, 200,300, Color.GREEN);
	  

	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				//racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				//racquet.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	private void move() {
		ball.move();
                ball2.move();
		
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
                
                
		Graphics2D g2d2 = (Graphics2D) g;
		g2d2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
                ball2.paint(g2d2);
                
		
	}
	

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
                    game.collision();	
                    game.move();
                    game.repaint();
                        
			Thread.sleep(20);
		}
	}

    private void collision() {
        ball.collision(ball2);
    }
        
        
}

