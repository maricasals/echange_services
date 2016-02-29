/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echange.test;

import echange.entity.Utilisateur;
import echange.exception.ExceptionUtilisateurInexistant;
import echange.exception.PaiementSoldeInsufisantException;
import echange.service.DBService;
import echange.service.EnvoieMessageService;
import echange.service.TransfertService;
import echange.service.UtilisateurService;
import echange.spring.SpringConfig;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author admin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfig.class)
public class MariaTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private EnvoieMessageService envoieMessage;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private TransfertService transfertService;

    @Autowired
    private DBService dbService;

    @Before
    public void beforeTout() throws PaiementSoldeInsufisantException, ExceptionUtilisateurInexistant {
        dbService.supprimerTout();

        Utilisateur u1 = new Utilisateur();
        u1.setSolde(10);
        u1.setEmail("u1email@gmail.com");
        u1.setId(1L);
        // Neccessaire d'ajoute Barcelone d'abord si on veut utiliser le constructeur
//        Utilisateur u1 = new Utilisateur(new Lieu("Barcelone"), new ArrayList<Commentaire>(), "email@gmail.com", "mdp", TypeUtil.ADMIN, 120);
        utilisateurService.save(u1);
//        Utilisateur u2 = new Utilisateur(new Lieu("Bordeaux"), new ArrayList<Commentaire>(), "email@gmail.com", "mdp2", TypeUtil.NORMAL, 70);
//        utilisateurService.save(u2);
        Utilisateur u2 = new Utilisateur();
        u2.setSolde(70);
        u2.setEmail("u2email@gmail.com");
        u2.setId(2L);
        utilisateurService.save(u2);

        transfertService.transfert(u1.getId(), u2.getId(), 120, "Bien!");
    }
    
    @Test
    public void transfert(){
        
    }
}
