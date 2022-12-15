/**
 *
 * Autor: Figueroa Martinez Joel Francisco
 * Fecha creacion: 08/12/2022
 * Fecha modificacion: 14/12/2022
 * Descripcion: ventana pricipal
 *
 */
package view;

import utilities.Sound;

public class PrincipalFrame extends javax.swing.JFrame {

    //declaracion de variables
    private final PanelGrafico panelGrafico;

    //constructor
    public PrincipalFrame() {

        panelGrafico = new PanelGrafico();
        this.add(this.panelGrafico);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        btnPause = new javax.swing.JLabel();
        btnPlay = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(0, 0, 0));

        btnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pause.png"))); // NOI18N
        btnPause.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPauseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPauseMouseEntered(evt);
            }
        });

        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/play.png"))); // NOI18N
        btnPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlayMouseEntered(evt);
            }
        });

        jSlider1.setMaximum(10);
        jSlider1.setMinimum(1);
        jSlider1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSlider1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(btnPlay)
                        .addGap(100, 100, 100)
                        .addComponent(btnPause)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPause)
                    .addComponent(btnPlay))
                .addGap(34, 34, 34)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Otorga el evento de mouse clicked al boton play
     *
     * @param evt
     */
    private void btnPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayMouseClicked
        panelGrafico.setPlay(true);
    }//GEN-LAST:event_btnPlayMouseClicked

    /**
     * Otorga el evento de mouse clicked al boton pause
     *
     * @param evt
     */
    private void btnPauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPauseMouseClicked
        panelGrafico.setPlay(false);
    }//GEN-LAST:event_btnPauseMouseClicked

    /**
     * otorga evento de mouse entered al boton play
     *
     * @param evt
     */
    private void btnPlayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayMouseEntered
        Sound.mousePass();
    }//GEN-LAST:event_btnPlayMouseEntered

    /**
     * otorga evento de mouse entered al boton pause
     *
     * @param evt
     */
    private void btnPauseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPauseMouseEntered
        Sound.mousePass();
    }//GEN-LAST:event_btnPauseMouseEntered
    
    /**
     * agrega velocidad
     * @param evt 
     */
    private void jSlider1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseClicked
        panelGrafico.setVelocidad(jSlider1.getValue());
    }//GEN-LAST:event_jSlider1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel btnPause;
    private javax.swing.JLabel btnPlay;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
