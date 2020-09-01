package game.model;

import javax.swing.*;
import java.util.*;

/**
 * short description of Spielablauf
 *
 * @author Brenden Jose
 * @version 1.0
 * @since 27.06.2020
 */

import java.util.Vector;

/**
 * short description of Spielablauf
 *
 * @author Brenden Jose
 * @version 1.0
 * @since 27.06.2020
 */
public class Spielablauf {
    private int aktuellerSpieler;
    private int maxPunkte = 200;
    private Vector<Spieler> spielerListe;
    public boolean spielbeendet;
    public Deck deck;
    public Ablagestapel ablagestapel;

    /**
     * Instantiates a new Spielablauf.
     *
     * @param spielerListe the spieler liste
     */
    public Spielablauf(Vector<Spieler> spielerListe) {
        this.spielerListe = spielerListe;
        deck = new Deck();
        ablagestapel = new Ablagestapel();
        setZufähligeSpielerNummer();
        spielbeendet = false;
    }


    //Methoden

    /**
     * Runde starten.
     */
    public void rundeStarten() {
        deck.mischen();
        setZufähligeSpielerNummer();
        for (int i = 0; i < spielerListe.size(); i++) {
            for (int j = 0; j < 7; j++) {
                spielerListe.get(i).addKarte(deck.ziehen());
            }
        }
        ablagestapel.addKarte(deck.ziehen());
    }

    /**
     * Runde beendet boolean.
     *
     * @return the boolean
     */
//Methode um zu schauen, ob die Runde beendet ist.
    public boolean rundeBeendet() {
        boolean var = false;
        for (Spieler spieler : this.spielerListe) {
            if (spieler.anzKarten() == 0) {
                if (spieler.tschauSagen) {
                    if (spieler.seppSagen) {
                        var = true;
                    }
                }
            }
        }

        return var;
    }

    /**
     * Runde beenden.
     */
    public void rundeBeenden() {
        deck.deckLeeren();
        for (int i = 0; i < spielerListe.size(); i++) {
            spielerListe.get(i).handLoeschen();
        }
        deck.deckherstellen();
        rundeStarten();
    }

    /**
     * Ziehen bestätigen boolean.
     *
     * @param spieler the spieler
     * @return the boolean
     */
    public boolean ziehenBestätigen(Spieler spieler) {
        boolean ziehen = true;
        for (int i = 0; i < spieler.getSpielerHand().size(); i++) {

            if (spieler.getSpielerHand().get(i).getSymbol() == ablagestapel.getObersteKarte().getSymbol() || spieler.getSpielerHand().get(i).getNummer() == ablagestapel.getObersteKarte().getNummer()) {
                ziehen = false;
            }

        }
        return ziehen;
    }

    /**
     * Tschau sagen.
     *
     * @param spieler the spieler
     */
    public void tschauSagen(Spieler spieler) {
        spieler.tschauSagen = true;
    }

    /**
     * Sepp sagen.
     *
     * @param spieler the spieler
     */
    public void seppSagen(Spieler spieler) {
        spieler.seppSagen = true;
    }

    /**
     * Get aktueller spieler spieler.
     *
     * @return the spieler
     */
    public Spieler getAktuellerSpieler() {
        return this.spielerListe.get(aktuellerSpieler);
    }

    public int getAktuellerSpielerNummer() {
        return aktuellerSpieler;
    }

    public int setZufähligeSpielerNummer() {
        Random zufall = new Random();
        aktuellerSpieler = zufall.nextInt(3);
        return aktuellerSpieler;
    }

    /**
     * Sets aktueller spieler.
     *
     * @param aktuellerSpieler the aktueller spieler
     */
    public void setAktuellerSpieler(int aktuellerSpieler) {
        this.aktuellerSpieler = aktuellerSpieler;
    }

    /**
     * Spiel beenden.
     */
    public void spielBeenden() {
        JLabel message = new JLabel(spielerListe.get(aktuellerSpieler).getName() + "hat das Spiel gewonnen.");
        JOptionPane.showMessageDialog(null, message);
        System.exit(0);
        spielbeendet = true;
    }


    /**
     * Karten deckauffüllen.
     */
    public void deckauffüllen() {
        int x = ablagestapel.getSize() - 1;
        for (int i = 0; i < x; i++) {
            deck.addKarte(ablagestapel.getKarte(i));
            ablagestapel.removeKarte(i);
        }
        deck.setOberste(deck.getKartenImDeck() - 1);
        deck.mischen();
    }

    /**
     * Karte spielbar boolean.
     *
     * @param karte the karte
     * @return the boolean
     */
    public boolean karteSpielbar(Karte karte) {
        boolean var = false;
        if (karte.getSymbol() == ablagestapel.getObersteKarte().getSymbol() || karte.getNummer() == ablagestapel.getObersteKarte().getNummer()) {
            var = true;
        } else if (karte.getSymbol() == ablagestapel.getObersteKarte().getSymbol() || karte.getNummer() == ablagestapel.getObersteKarte().getNummer()) {
            var = true;
        }
        return var;
    }

    /**
     * Zug bestätigen.
     *
     * @param spieler the spieler
     * @param karte   the karte
     * @param index   the index
     * @throws InvalidSymbolException the invalid symbol submission exception
     * @throws InvalidNummerException the invalid nummer submission exception
     */
    public void zugBestätigen(Spieler spieler, Karte karte, int index) throws InvalidSymbolException, InvalidNummerException {
        //Karte Spielbar
        if (karteSpielbar(karte)) {

            spieler.removeKarte(karte);
            ablagestapel.addKarte(karte);

            if (rundeBeendet()) {
                //karten der anderen Spieler.
                Vector<Karte> alleKartenVonHand = new Vector<>();
                JOptionPane.showMessageDialog(null, spielerListe.get(aktuellerSpieler).getName() + "hat Runde gewonnen.", "Tschau Sepp", JOptionPane.INFORMATION_MESSAGE);

                //karten der anderen Spieler hinzufügen
                for (int i = 0; i < spielerListe.size(); i++) {
                    for (int j = 0; j < spielerListe.get(i).getSpielerHand().size(); j++) {
                        alleKartenVonHand.add(spielerListe.get(i).getSpielerHand().get(j));
                    }
                }
                //Punkte adden
                for (int i = 0; i < alleKartenVonHand.size(); i++) {
                    spieler.addPunkte(alleKartenVonHand.get(i).getPunkte());
                }
                //spielbeenden
                if (spieler.getPunkt() >= maxPunkte) {
                    spielBeenden();
                }
                //runde beenden
                rundeBeenden();
            }
            //Tschau kartenziehen
            else if (spieler.getSpielerHand().size() == 1) {
                if (!spieler.tschauSagen) {
                    if (deck.getKartenImDeck() < 5) {
                        deckauffüllen();
                    }
                    spieler.addKarte(deck.ziehen());
                    spieler.addKarte(deck.ziehen());
                    JOptionPane.showMessageDialog(null, "Zwei Karten ziehen! Nicht Tschau gesagt", "Tschau Sepp", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            //Sepp kartenziehen
            else if (spieler.getSpielerHand().size() == 0) {
                if (!spieler.seppSagen) {
                    if (deck.getKartenImDeck() < 5) {
                        deckauffüllen();
                    }
                    spieler.addKarte(deck.ziehen());
                    spieler.addKarte(deck.ziehen());
                    spieler.addKarte(deck.ziehen());
                    spieler.addKarte(deck.ziehen());
                    JOptionPane.showMessageDialog(null, "Vier Karten ziehen! Nicht Sepp gesagt", "Tschau Sepp", JOptionPane.INFORMATION_MESSAGE);
                    spieler.tschauSagen = false;
                }
            }
        }
        //Karte nicht Spielbar
        else if (!karteSpielbar(karte)) {
            //Symbol
            if (karte.getSymbol() != ablagestapel.getObersteKarte().getSymbol()) {
                JLabel message = new JLabel("Ungültiger Zug, bitte diesen Symbol spielen: " + ablagestapel.getObersteKarte().getSymbol() + " oder diese Nummer/Figur spielen: " + ablagestapel.getObersteKarte().getNummer());
                JOptionPane.showMessageDialog(null, message, "Tschau Sepp", JOptionPane.INFORMATION_MESSAGE);
                throw new InvalidSymbolException(message.getText(), karte.getSymbol(), ablagestapel.getObersteKarte().getSymbol());
            }
            //Nummer
            if (karte.getNummer() != ablagestapel.getObersteKarte().getNummer()) {
                JLabel message = new JLabel("Ungültiger Zug, bitte diesen Symbol spielen: " + ablagestapel.getObersteKarte().getSymbol() + " oder diese Nummer/Figur spielen: " + ablagestapel.getObersteKarte().getNummer());
                JOptionPane.showMessageDialog(null, message, "Tschau Sepp", JOptionPane.INFORMATION_MESSAGE);
                throw new InvalidNummerException(message.getText(), karte.getNummer(), ablagestapel.getObersteKarte().getNummer());
            }
        }
        //Spieler wechseln
        if (aktuellerSpieler == 3) {
            aktuellerSpieler = 0;
        } else {
            aktuellerSpieler++;
        }
    }

}



