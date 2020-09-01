/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model;

/**
 * short description of InvalidNummerException
 *
 * @author Brenden Jose
 * @version 1.0
 * @since 27.06.2020
 */
public class InvalidNummerException extends Exception {
    private Karte.Nummer excepted;
    private Karte.Nummer actual;

    /**
     * Instantiates a new Invalid nummer exception.
     *
     * @param message  the message
     * @param actual   the actual
     * @param excepted the excepted
     */
    public InvalidNummerException(String message, Karte.Nummer actual, Karte.Nummer excepted) {
        super(message);
        this.actual = actual;
        this.excepted = excepted;
    }


}
