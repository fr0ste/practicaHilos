package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.event.MouseInputListener;

public class PanelGrafico extends javax.swing.JPanel implements Runnable, KeyListener, MouseInputListener, MouseMotionListener {

    private int x = 20;
    private int y = 20;
    private int posX = 20;
    private int posY = 20;
    private int angulo =0;
    private final int margen = 25;
    private final int ballWidth = 32;
    private final int ballHeight=32;
    int direccionX = 1;
    int direccionY = 1;
    private ImageIcon fondo;

    public PanelGrafico() {
        initComponents();
        
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setBounds(0, 0, 300, 300);
        this.setBackground(Color.MAGENTA);
        this.setSize(400, 300);
        
        
        this.addKeyListener(this); //agregar escucha al panel con los teclados
        this.setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        
        Dimension tamanio = this.getSize();
        fondo = new ImageIcon(getClass().getResource("../img/background.jpg"));
        g.drawImage(fondo.getImage(), 0, 0, tamanio.width,tamanio.height,null);
        setOpaque(false);
        
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.yellow);
        g2d.fillOval(posX, posY, ballWidth, ballHeight);
        g2d.setColor(Color.BLUE);
        g2d.drawOval(posX, posY, ballHeight, ballWidth);
        
        
        
//        Toolkit t = Toolkit.getDefaultToolkit();
//        Image img = t.getImage("resources/images/continuar.png");
//        g2d.rotate(angulo*Math.PI/180, posX, posY);
//        g2d.drawImage(img, posX, posY, this);


        Thread hilo = new Thread(this);
        hilo.start();
        try {
            Thread.sleep(15);
        } catch (InterruptedException ex) {
            Logger.getLogger(PanelGrafico.class.getName()).log(Level.SEVERE, null, ex);
        }

      repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {

       if (posX + direccionX-margen< 0)
			direccionX = 1;
		if (posX + direccionX +margen> this.getWidth() - ballWidth)
			direccionX = -1;
		if (posY + direccionY-margen < 0)
			direccionY = 1;
		if (posY + direccionY+margen > this.getHeight()-ballHeight)
			direccionY = -1;
		
		posX = posX + direccionX;
		posY = posY + direccionY;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int codigo = ke.getExtendedKeyCode();
        
        if (codigo==ke.VK_UP) {
            System.out.println("flecha arriba");
            angulo=(angulo+90)%360;
        }
        
        
        if (codigo==ke.VK_DOWN) {
            System.out.println("flecha abajo");
           y=(y+5)%this.getHeight();
            
        }
        
        
        if (codigo==ke.VK_LEFT) {
            System.out.println("flecha izquierda");
            x-=5;
        }
        
        
        if (codigo==ke.VK_RIGHT) {
            System.out.println("flecha derecha");
            x+=5;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
//        System.out.println("click");
//        x=me.getX();
//        y=me.getY();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        
        System.out.println("dragged");
        if((me.getX()>=margen-ballWidth && me.getY()>=margen-ballHeight)  && (me.getX()<=this.getWidth()-margen) && me.getY()<=this.getHeight()-margen){
            posX=me.getX();
           posY=me.getY();
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
