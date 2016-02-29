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
public class ExceptionUtilisateurDejaInscrit extends Exception {

    /**
     * Creates a new instance of <code>ExceptionUtilisateurDejaInscrit</code>
     * without detail message.
     */
    public ExceptionUtilisateurDejaInscrit() {
    }

    /**
     * Constructs an instance of <code>ExceptionUtilisateurDejaInscrit</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionUtilisateurDejaInscrit(String msg) {
        super(msg);
    }
}
