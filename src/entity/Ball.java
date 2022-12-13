package entity;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class Ball {

    private int posX = 20;
    private int posY = 20;
    private final int margen = 25;
    private final int ballWidth = 32;
    private final int ballHeight = 32;
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

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getDireccionX() {
        return direccionX;
    }

    public void setDireccionX(int direccionX) {
        this.direccionX = direccionX;
    }

    public int getDireccionY() {
        return direccionY;
    }

    public void setDireccionY(int direccionY) {
        this.direccionY = direccionY;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void move() {
        if (posX + direccionX - margen < 0) {
            direccionX = 1;
        }
        if (posX + direccionX + margen > panel.getWidth() - ballWidth) {
            direccionX = -1;
        }
        if (posY + direccionY - margen < 0) {
            direccionY = 1;
        }
        if (posY + direccionY + margen > panel.getHeight() - ballHeight) {
            direccionY = -1;
        }

        posX = posX + direccionX;
        posY = posY + direccionY;
    }

    public void collision(Ball ball) {
        if (ball.getBounds().intersects(this.getBounds())) {
            direccionY *= -1;
            direccionX *= -1;
            ball.setDireccionX(direccionX*-1);
            ball.setDireccionY(direccionY*-1);

        }
    }

    public void paint(Graphics2D g) {
        g.setColor(this.color);
        g.fillOval(posX, posY, this.ballWidth, this.ballHeight);
        g.setColor(this.color);
        g.drawOval(posX, posY, ballHeight, ballWidth);

    }

    public Rectangle getBounds() {
        return new Rectangle(posX + ballWidth, posY + ballHeight, this.ballWidth, this.ballHeight);
    }
}
