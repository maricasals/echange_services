/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echange.test;

import echange.entity.Utilisateur;
import echange.exception.ExceptionUtilisateurInexistant;
import echange.service.DBService;
import echange.service.EnvoieMessage;
import echange.service.UtilisateurService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import echange.spring.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author ETY
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SpringConfig.class)
public class SpringTest {
    
    @PersistenceContext
    private EntityManager em;
    
    @Autowired
    EnvoieMessage envoieMessage;
    
    @Autowired
    UtilisateurService utilisateurService;
    
    @Autowired
    private DBService dbService;
    
    @Before
    public void beforeTout(){
        dbService.supprimerTout();
    }
    
    @Test
    public void envoieMessage() throws ExceptionUtilisateurInexistant{
        Utilisateur u1 = new Utilisateur();
        u1.setId(1L);
        utilisateurService.save(u1);
        Utilisateur u2 = new Utilisateur();
        u2.setId(2L);
        utilisateurService.save(u2);
        envoieMessage.envoieMessage(1L, 2L, "qefesjkfe", "ypoooooooooooo");

    }
    
    
}
