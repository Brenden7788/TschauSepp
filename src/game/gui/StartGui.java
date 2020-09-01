package game.gui;

import game.model.Spieler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * short description of StartGui
 *
 * @author Brenden Jose
 * @version 1.0
 * @since 27.06.2020
 */
public class StartGui extends JFrame {
    private Vector<Spieler> spielerListe;

    //All elements
    BufferedImage bufferedImage = null;
    BackgroundJPanel backgroundpanel = new BackgroundJPanel();
    JLabel tschausepp = new JLabel("Tschau Sepp");
    JLabel sp1l = new JLabel("Spieler 1:");
    JLabel sp2l = new JLabel("Spieler 2:");
    JLabel sp3l = new JLabel("Spieler 3:");
    JLabel sp4l = new JLabel("Spieler 4:");
    JTextField sp1 = new JTextField(10);
    JTextField sp2 = new JTextField(10);
    JTextField sp3 = new JTextField(10);
    JTextField sp4 = new JTextField(10);
    JButton startbtn = new JButton("start");
    JPanel nord = new JPanel();
    JPanel spieler = new JPanel();
    JPanel start = new JPanel();

    /**
     * Instantiates a new Start gui.
     */
    public StartGui() {
        spielerListe = new Vector<>();

        try {
            bufferedImage = ImageIO.read(new File("Bilder/320px-Französische_Jasskarten.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        backgroundpanel.setPreferredSize(new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight()));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        nord.setLayout(new BorderLayout());
        nord.add(tschausepp, BorderLayout.CENTER);

        spieler.setLayout(new GridLayout(2, 3));
        spieler.add(sp1l);
        spieler.add(sp2l);
        spieler.add(sp3l);
        spieler.add(sp4l);

        spieler.add(sp1);
        spieler.add(sp2);
        spieler.add(sp3);
        spieler.add(sp4);


        start.setLayout(new BorderLayout());
        start.add(startbtn, BorderLayout.EAST);

        startbtn.setBorder(null);
        startbtn.setFocusable(false);
        startbtn.setBackground(Color.gray);
        startbtn.setForeground(Color.white);
        startbtn.setPreferredSize(new Dimension(100, 30));

        //actionlistener
        startbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (sp1.getText().isEmpty() || sp2.getText().isEmpty() || sp3.getText().isEmpty() || sp4.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Bitte alle Felder ausfüllen!", "Fehlermeldung", JOptionPane.WARNING_MESSAGE);
                } else if (sp1.getText().length() > 15 || sp2.getText().length() > 15 || sp3.getText().length() > 15 || sp4.getText().length() > 15) {
                    JOptionPane.showMessageDialog(null, "Bitte Höchstens 15 Zeichen!", "Fehlermeldung", JOptionPane.WARNING_MESSAGE);
                } else if (sp1.getText().length() < 2 || sp2.getText().length() < 2 || sp3.getText().length() < 2 || sp4.getText().length() < 2) {
                    JOptionPane.showMessageDialog(null, "Bitte Höchstens mind 2 Zeichen!", "Fehlermeldung", JOptionPane.WARNING_MESSAGE);
                } else {
                    Spieler spieler1 = new Spieler(sp1.getText());
                    spielerListe.add(spieler1);

                    Spieler spieler2 = new Spieler(sp2.getText());
                    spielerListe.add(spieler2);

                    Spieler spieler3 = new Spieler(sp3.getText());
                    spielerListe.add(spieler3);

                    Spieler spieler4 = new Spieler(sp4.getText());
                    spielerListe.add(spieler4);
                    dispose();
                    new GameGui(spielerListe).setVisible(true);
                }
            }
        });

        backgroundpanel.setLayout(new BorderLayout());

        backgroundpanel.add(nord, BorderLayout.NORTH);
        nord.setOpaque(false);

        backgroundpanel.add(spieler, BorderLayout.CENTER);
        spieler.setOpaque(false);

        backgroundpanel.add(start, BorderLayout.SOUTH);
        start.setOpaque(false);

        getContentPane().add(backgroundpanel);

        pack();
        setVisible(true);
    }

    /**
     * The type Background j panel.
     */
    class BackgroundJPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(bufferedImage, 0, 0, this);
        }
    }
}
