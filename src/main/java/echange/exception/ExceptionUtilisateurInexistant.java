/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echange.exception;

/**
 *
 * @author admin
 */
public class ExceptionUtilisateurInexistant extends Exception {

    /**
     * Creates a new instance of <code>ExceptionUtilisateurInexistant</code>
     * without detail message.
     */
    public ExceptionUtilisateurInexistant() {
    }

    /**
     * Constructs an instance of <code>ExceptionUtilisateurInexistant</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionUtilisateurInexistant(String msg) {
        super(msg);
    }
}
