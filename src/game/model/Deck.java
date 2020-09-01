package game.model;

import java.util.Collections;
import java.util.Vector;

/**
 * short description of Deck
 *
 * @author Brenden Jose
 * @version 1.0
 * @since 27.06.2020
 */
public class Deck {

    private Vector<Karte> deck;
    private int kartenImDeck;
    private int oberste;

    /**
     * Instantiates a new Deck.
     */
    public Deck() {
        deck = new Vector<>();
        deckherstellen();
    }


    //Methoden

    /**
     * Deckherstellen.
     */
    public void deckherstellen() {
        Karte.Symbol[] symbols = Karte.Symbol.values();
        kartenImDeck = 0;
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < symbols.length; i++) {

                Karte.Symbol symbol = symbols[i];

                for (int j = 0; j < 9; j++) {
                    Karte karte = new Karte(symbol, Karte.Nummer.getNummer(j));
                    deck.add(karte);
                    kartenImDeck++;
                }
            }
        }
        oberste = deck.size() - 1;
        assert deck.get(oberste) != null;
    }


    /**
     * Mischen.
     */
    public void mischen() {
        Collections.shuffle(deck);
    }

    /**
     * Ziehen karte.
     *
     * @return the karte
     */
    public Karte ziehen() {
        Karte gezogeneKarte = deck.get(oberste);
        deck.remove(gezogeneKarte);
        oberste--;
        kartenImDeck--;
        return gezogeneKarte;
    }

    /**
     * Add karte.
     *
     * @param karte the karte
     */
    public void addKarte(Karte karte) {
        deck.add(karte);
    }


    /**
     * Deck leeren.
     */
    public void deckLeeren() {
        deck.removeAll(deck);
    }

    /**
     * Gets karten im deck.
     *
     * @return the karten im deck
     */
    public int getKartenImDeck() {
        return kartenImDeck;
    }

    public void setOberste(int oberste) {
        this.oberste = oberste;
    }

}
