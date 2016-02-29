/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echange.service;

import echange.entity.Paiement;
import echange.entity.Utilisateur;
import echange.exception.ExceptionUtilisateurInexistant;
import echange.exception.PaiementSoldeInsufisantException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class TransfertService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UtilisateurService us;

    @Autowired
    private ConfigurationService cs;

    @Autowired
    private EnvoieMessageService envoieMessage;

    public void transfert(Long idEmet, long idDest, long montant, String msg) throws PaiementSoldeInsufisantException, ExceptionUtilisateurInexistant {

        us.findOne(idEmet);

        if (us.findOne(idEmet).getSolde() > cs.getBalanceMinSolde()) {
            int s = us.findOne(idEmet).getSolde();
            Paiement p = new Paiement();
            p.setMontant(montant);
            Utilisateur u = us.findOne(idEmet);
            u.setSolde(s - (int) montant);
            us.save(u);
            
            int ns = us.findOne(idDest).getSolde();
            us.findOne(idDest).setSolde(ns + (int) montant);

            System.out.println("Votre paiement à été bien effectué" + "\n" + "Votre solde inicial était de :" + s + "\n" + "Votre solde final est de :" + us.findOne(idEmet).getSolde() + "\n" + msg);
            envoieMessage.envoieMessage(idEmet, idDest, "Le payement a été bien effectuer", "blabla");
        } else {
            throw new PaiementSoldeInsufisantException();
        }
    }

}
