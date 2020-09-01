package game.model;


import java.util.Vector;

/**
 * short description of Spieler
 *
 * @author Brenden Jose
 * @version 1.0
 * @since 27.06.2020
 */
public class Spieler {
    private String name;
    private int punkt = 0;
    private Vector<Karte> spielerHand;
    /**
     * The Tschau sagen.
     */
    public boolean tschauSagen = false;
    /**
     * The Sepp sagen.
     */
    public boolean seppSagen = false;

    /**
     * Instantiates a new Spieler.
     *
     * @param name the name
     */
    public Spieler(String name) {
        this.name = name;
        spielerHand = new Vector<>();
    }


    //Methoden

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Anz karten int.
     *
     * @return the int
     */
    public int anzKarten() {
        return spielerHand.size();
    }

    /**
     * Gets punkt.
     *
     * @return the punkt
     */
    public int getPunkt() {
        return punkt;
    }

    /**
     * Sets punkt.
     *
     * @param punkt the punkt
     */
    public void setPunkt(int punkt) {
        this.punkt = punkt;
    }

    /**
     * Gets spieler hand.
     *
     * @return the spieler hand
     */
    public Vector<Karte> getSpielerHand() {
        return spielerHand;
    }

    /**
     * Sets spieler hand.
     *
     * @param spielerHand the spieler hand
     */
    public void setSpielerHand(Vector<Karte> spielerHand) {
        this.spielerHand = spielerHand;
    }

    /**
     * Add karte.
     *
     * @param karte the karte
     */
    public void addKarte(Karte karte) {
        spielerHand.add(karte);
    }

    /**
     * Remove karte.
     *
     * @param karte the karte
     */
    public void removeKarte(Karte karte) {
        spielerHand.remove(karte);
    }

    /**
     * Add punkte.
     *
     * @param punkte the punkte
     */
    public void addPunkte(int punkte) {
        punkt = punkt + punkte;
    }

    /**
     * Kanntschau sagen boolean.
     *
     * @return the boolean
     */
    public boolean kanntschauSagen() {
        boolean tschau = false;
        if (getSpielerHand().size() == 2) {
            tschau = true;
        }
        return tschau;
    }

    /**
     * Kannsepp sagen boolean.
     *
     * @return the boolean
     */
    public boolean kannseppSagen() {
        boolean sepp = false;
        if (getSpielerHand().size() == 1) {
            sepp = true;
        }
        return sepp;
    }

    /**
     * Hand loeschen.
     */
    public void handLoeschen() {
        spielerHand.removeAll(spielerHand);
    }

}
