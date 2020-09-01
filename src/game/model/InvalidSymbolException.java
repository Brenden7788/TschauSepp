/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model;

/**
 * short description of InvalidSymbolException
 *
 * @author Brenden Jose
 * @version 1.0
 * @since 27.06.2020
 */
public class InvalidSymbolException extends Exception {
    private Karte.Symbol excepted;
    private Karte.Symbol actual;

    /**
     * Instantiates a new Invalid symbol exception.
     *
     * @param message  the message
     * @param actual   the actual
     * @param excepted the excepted
     */
    public InvalidSymbolException(String message, Karte.Symbol actual, Karte.Symbol excepted) {
        super(message);
        this.actual = actual;
        this.excepted = excepted;
    }

}
