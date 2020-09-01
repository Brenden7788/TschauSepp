package game.gui;

import game.model.InvalidNummerException;
import game.model.InvalidSymbolException;
import game.model.Spielablauf;
import game.model.Spieler;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * short description of GameGui
 *
 * @author Brenden Jose
 * @version 1.0
 * @since 27.06.2020
 */
public class GameGui extends JFrame {


    Spielablauf spiel;
    Vector<Spieler> spielerListe;
    Vector<JButton> kartenButtons = new Vector<JButton>();
    Vector<String> kartenIds;
    //index
    int i = 0;

    //ablageStapel
    private JButton ablageStapelbtn;
    //aktuellerSpieler
    private JLabel aktuellerSpielerLabel;
    //deck
    private JButton deckbtn;
    //Karte 1-14
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JButton jButton10;
    private JButton jButton11;
    private JButton jButton12;
    private JButton jButton13;
    private JButton jButton14;

    //aktueller Spieler
    private JLabel jLabel1;
    //Punkte:
    private JLabel jLabel2;
    //Hand
    private JLabel jLabel3;

    private JPanel jPanel1;
    private JPanel jPanel2;


    private JButton legenbtn;
    private JLabel punkteLabel;
    private JButton seppbtn;
    private JButton tschaubtn;

    /**
     * Instantiates a new Game gui.
     */
    public GameGui() {

    }

    /**
     * Instantiates a new Game gui.
     *
     * @param spielerListe the spieler liste
     */
    GameGui(Vector<Spieler> spielerListe) {
        super("Tschau Sepp");
        initComponents();
        spiel = new Spielablauf(spielerListe);
        addButtons();
        spiel.rundeStarten();
        setButtonImages();
        setAktuellerSpielerName();
        setAblageStapelbtn();
        setDeckbtn();
    }

    /**
     * Sets button images.
     */
    public void setButtonImages() {
        String listString = spiel.getAktuellerSpieler().getSpielerHand().stream().map(Object::toString).collect(Collectors.joining(","));
        String[] kartenNamen = listString.split(",");
        kartenIds = new Vector<>();
        kartenIds.addAll(Arrays.asList(kartenNamen));
        for (int i = 0; i < kartenIds.size(); i++) {
            kartenButtons.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/" + spiel.getAktuellerSpieler().getSpielerHand().get(i).getSymbol() + " " + spiel.getAktuellerSpieler().getSpielerHand().get(i).getNummer() + ".gif")));
        }
        for (int i = kartenIds.size(); i < kartenButtons.size(); i++) {
            kartenButtons.get(i).setIcon(null);
        }
    }

    /**
     * Add buttons.
     */
    public void addButtons() {
        kartenButtons.add(jButton1);
        kartenButtons.add(jButton2);
        kartenButtons.add(jButton3);
        kartenButtons.add(jButton4);
        kartenButtons.add(jButton5);
        kartenButtons.add(jButton6);
        kartenButtons.add(jButton7);
        kartenButtons.add(jButton8);
        kartenButtons.add(jButton9);
        kartenButtons.add(jButton10);
        kartenButtons.add(jButton12);
        kartenButtons.add(jButton13);
        kartenButtons.add(jButton14);
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        aktuellerSpielerLabel = new JLabel();
        punkteLabel = new JLabel();
        legenbtn = new JButton();
        seppbtn = new JButton();
        tschaubtn = new JButton();
        ablageStapelbtn = new JButton();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();
        jButton8 = new JButton();
        jButton9 = new JButton();
        jButton10 = new JButton();
        jButton11 = new JButton();
        jButton12 = new JButton();
        jButton13 = new JButton();
        jButton14 = new JButton();
        jLabel3 = new JLabel();
        deckbtn = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Arial", 0, 15));
        jLabel1.setText("Aktueller Spieler:");

        jLabel2.setFont(new Font("Arial", 0, 15));
        jLabel2.setText("Punkte:");

        jLabel3.setFont(new Font("Arial", 0, 30));
        jLabel3.setText("Aktueller Spieler Hand:");

        aktuellerSpielerLabel.setFont(new Font("Arial", 0, 15));
        aktuellerSpielerLabel.setText("name");

        punkteLabel.setFont(new Font("Arial", 0, 15));
        punkteLabel.setText("0");

        seppbtn.setText("Sepp");
        seppbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (spiel.getAktuellerSpieler().kannseppSagen()) {
                    spiel.seppSagen(spiel.getAktuellerSpieler());
                } else {
                    JOptionPane.showMessageDialog(null, "Du hast zu viele Karten um Sepp zu sagen!", "Tschau Sepp", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        tschaubtn.setText("Tschau");
        tschaubtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (spiel.getAktuellerSpieler().kanntschauSagen()) {
                    spiel.tschauSagen(spiel.getAktuellerSpieler());
                } else {
                    JOptionPane.showMessageDialog(null, "Du hast zu viele Karten um Tschau zu sagen!", "Tschau Sepp", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        //Card button listener
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (kartenIds.get(0) != null) {
                    i = 0;
                }
            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (kartenIds.get(1) != null) {
                    i = 1;
                }
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (kartenIds.get(2) != null) {
                    i = 2;
                }
            }
        });

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (kartenIds.get(3) != null) {
                    i = 3;
                }
            }
        });

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (kartenIds.get(4) != null) {
                    i = 4;
                }
            }
        });

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (kartenIds.get(5) != null) {
                    i = 5;
                }
            }
        });

        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (kartenIds.get(6) != null) {
                    i = 6;
                }
            }
        });

        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (kartenIds.get(7) != null) {
                    i = 7;
                }
            }
        });

        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (kartenIds.get(8) != null) {
                    i = 8;
                }
            }
        });

        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (kartenIds.get(9) != null) {
                    i = 9;
                }
            }
        });

        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (kartenIds.get(10) != null) {
                    i = 10;
                }
            }
        });

        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (kartenIds.get(11) != null) {
                    i = 11;
                }
            }
        });

        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (kartenIds.get(12) != null) {
                    i = 12;
                }
            }
        });

        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (kartenIds.get(13) != null) {
                    i = 13;
                }
            }
        });
        //ziehen
        deckbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deckbtnActionPerformed(evt);
            }
        });

        legenbtn.setText("Legen");
        legenbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                legenbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(legenbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(ablageStapelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jButton1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton3)))
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(deckbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addGap(79, 79, 79)
                                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel2))
                                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                                .addGap(17, 17, 17)
                                                                                                .addComponent(punkteLabel))
                                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(aktuellerSpielerLabel))))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(seppbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(tschaubtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(13, 13, 13)
                                                                .addComponent(jButton4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jButton5)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton6)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton7)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton8)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton9)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton10)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton11)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton12)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton13)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton14)))))
                                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(aktuellerSpielerLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(punkteLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                                                .addComponent(tschaubtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(seppbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(ablageStapelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(deckbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(legenbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                        .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    //Action for buttons
    private void deckbtnActionPerformed(java.awt.event.ActionEvent evt) {
        if (spiel.ziehenBestätigen(spiel.getAktuellerSpieler())) {

            if (spiel.deck.getKartenImDeck() < 5) {
                spiel.deckauffüllen();
            }

            spiel.getAktuellerSpieler().addKarte(spiel.deck.ziehen());

            if (spiel.getAktuellerSpielerNummer() == 3) {
                spiel.setAktuellerSpieler(0);
            } else {
                spiel.setAktuellerSpieler(spiel.getAktuellerSpielerNummer() + 1);
            }

            setAktuellerSpielerName();
            setButtonImages();

        } else {
            JOptionPane.showMessageDialog(null, "Du kannst eine Karte spielen!", "Tschau Sepp", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    private void legenbtnActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            spiel.zugBestätigen(spiel.getAktuellerSpieler(), spiel.getAktuellerSpieler().getSpielerHand().get(i), i);
            setPunkteString();
        } catch (InvalidSymbolException ex) {
            Logger.getLogger(GameGui.class.getName()).log(Level.SEVERE, null, ex);

        } catch (InvalidNummerException ex) {
            Logger.getLogger(GameGui.class.getName()).log(Level.SEVERE, null, ex);

        }
        this.revalidate();
        setButtonImages();
        setAblageStapelbtn();
        setAktuellerSpielerName();
        close();
    }

    //Methods to refresh label and other buttons

    /**
     * Sets ablage stapelbtn.
     */
    public void setAblageStapelbtn() {
        ablageStapelbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/" + spiel.ablagestapel.getObersteKarte().getSymbol() + " " + spiel.ablagestapel.getObersteKarte().getNummer() + ".gif")));
    }

    /**
     * Sets deckbtn.
     */
    public void setDeckbtn() {
        deckbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/Deck.jpg")));
    }

    /**
     * Sets punkte string.
     */
    public void setPunkteString() {
        int a = spiel.getAktuellerSpieler().getPunkt();
        String string = String.valueOf(a);
        punkteLabel.setText(string);
    }

    /**
     * Sets aktueller spieler name.
     */
    public void setAktuellerSpielerName() {
        aktuellerSpielerLabel.setText(spiel.getAktuellerSpieler().getName());
    }

    /**
     * Close.
     */
    public void close() {
        if (spiel.spielbeendet) {
            this.dispose();
        }
    }

}
