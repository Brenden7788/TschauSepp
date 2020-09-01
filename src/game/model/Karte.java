package game.model;


/**
 * short description of Karte
 *
 * @author Brenden Jose
 * @version 1.0
 * @since 27.06.2020
 */
public class Karte {

    /**
     * The enum Nummer.
     */
    enum Nummer {

        Sechs, Sieben, Acht, Neun, Zehn, Under, Ober, König, Ass;

        private static final Nummer[] nummer = Nummer.values();

        public static Nummer getNummer(int i) {
            return Nummer.nummer[i];
        }
    }

    /**
     * The enum Symbol.
     */
    enum Symbol {

        Eichel, Rosen, Schellen, Schilten;

        private static final Symbol[] symbols = Symbol.values();

        private static Symbol getSymbol(int i) {
            return Symbol.symbols[i];
        }
    }

    private final Nummer nummer;
    private final Symbol symbol;
    private int punkte;

    /**
     * Instantiates a new Karte.
     *
     * @param symbol the symbol
     * @param nummer the nummer
     */
    public Karte(Symbol symbol, Nummer nummer) {
        this.symbol = symbol;
        this.nummer = nummer;
        punkteDerKarten(nummer);
    }


    /**
     * Gets nummer.
     *
     * @return the nummer
     */
    public Nummer getNummer() {
        return nummer;
    }

    /**
     * Gets symbol.
     *
     * @return the symbol
     */
    public Symbol getSymbol() {
        return symbol;
    }

    /**
     * Sets punkte.
     *
     * @param punkte the punkte
     */
    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    /**
     * Gets punkte.
     *
     * @return the punkte
     */
    public int getPunkte() {
        return punkte;
    }


    /**
     * Punkte der karten.
     *
     * @param nummer the nummer
     */
    public void punkteDerKarten(Nummer nummer) {
        Nummer[] nummer1 = Nummer.values();
        if (nummer.equals(nummer1[0])) {
            setPunkte(6);
        } else if (nummer.equals(nummer1[1])) {
            setPunkte(7);
        } else if (nummer.equals(nummer1[2])) {
            setPunkte(8);
        } else if (nummer.equals(nummer1[3])) {
            setPunkte(9);
        } else if (nummer.equals(nummer1[4])) {
            setPunkte(10);
        } else if (nummer.equals(nummer1[5])) {
            setPunkte(20);
        } else if (nummer.equals(nummer1[6])) {
            setPunkte(3);
        } else if (nummer.equals(nummer1[7])) {
            setPunkte(4);
        } else if (nummer.equals(nummer1[8])) {
            setPunkte(11);
        }

    }
}
