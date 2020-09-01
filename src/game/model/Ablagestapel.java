package game.model;

import java.util.Vector;

/**
 * short description of Ablagestapel
 *
 * @author Brenden Jose
 * @version 1.0
 * @since 27.06.2020
 */
public class Ablagestapel {
    private Vector<Karte> ablageStapel;

    /**
     * Instantiates a new Ablagestapel.
     */
    public Ablagestapel() {
        ablageStapel = new Vector<>();
    }

    /**
     * Gets ablage stapel.
     *
     * @return the ablage stapel
     */
    public Vector<Karte> getAblageStapel() {
        return ablageStapel;
    }

    /**
     * Sets ablage stapel.
     *
     * @param ablageStapel the ablage stapel
     */
    public void setAblageStapel(Vector<Karte> ablageStapel) {
        this.ablageStapel = ablageStapel;
    }

    /**
     * Gets karte.
     *
     * @param i the
     * @return the karte
     */
    public Karte getKarte(int i) {
        return ablageStapel.get(i);
    }

    /**
     * Add karte.
     *
     * @param karte the karte
     */
    public void addKarte(Karte karte) {
        ablageStapel.add(karte);
    }

    /**
     * Remove karte.
     *
     * @param i the
     */
    public void removeKarte(int i) {
        ablageStapel.remove(i);
    }

    /**
     * Gets oberste karte.
     *
     * @return the oberste karte
     */
    public Karte getObersteKarte() {
        return ablageStapel.get(ablageStapel.size() - 1);
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return ablageStapel.size();
    }

}
