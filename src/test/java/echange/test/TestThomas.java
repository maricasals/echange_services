/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echange.test;

import echange.entity.Annonce;
import echange.entity.Categorie;
import static echange.entity.EnumAnnonce.DEMANDE;
import static echange.entity.EnumAnnonce.OFFRE;
import echange.entity.Lieu;
import echange.entity.TypeUtil;
import echange.entity.Utilisateur;
import echange.exception.ExceptionUtilisateurInexistant;
import echange.service.AnnonceService;
import echange.service.CategorieService;
import echange.service.CommentaireService;
import echange.service.DBService;
import echange.service.EnvoieMessageService;
import echange.service.LieuService;
import echange.service.MessageService;
import echange.service.PaiementService;
import echange.service.UtilisateurService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import echange.spring.SpringConfig;
import java.util.ArrayList;
import java.util.List;
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
public class TestThomas {
    
    @PersistenceContext
    private EntityManager em;
    
    @Autowired
    private AnnonceService annonceService;
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private CommentaireService commentaireService;
    @Autowired
    private DBService dbService;
    @Autowired
    private EnvoieMessageService envoieMessage;
    @Autowired
    private LieuService lieuService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private PaiementService paiementService;
    @Autowired
    private UtilisateurService utilisateurService;
    
    
    
    @Before
    public void beforeTout(){
        dbService.supprimerTout();
    }
    
//    @Test
    public void envoieMessage() throws ExceptionUtilisateurInexistant{
        Utilisateur u1 = new Utilisateur();
        u1.setId(1L);
        utilisateurService.save(u1);
        Utilisateur u2 = new Utilisateur();
        u2.setId(2L);
        utilisateurService.save(u2);
        envoieMessage.envoieMessage(1L, 2L, "qefesjkfe", "ypoooooooooooo");

    }
    
    @Test
    public void rechercheTest(){
        Categorie c1 = new Categorie(1L, "a ");
        Categorie c2 = new Categorie(2L, "b ");
        Categorie c3 = new Categorie(3L, "c ");
        categorieService.save(c1);
        categorieService.save(c2);
        categorieService.save(c3);
        
        Annonce a1 = new Annonce(1L,"annonce1", "contenu1", 5);
        a1.setCategories(c1);
        a1.setType(OFFRE);
        Utilisateur u=new Utilisateur();
        u.setEmail("***********************************************");
        a1.setUtilisateur(u);
        utilisateurService.save(u);
        annonceService.save(a1);
        
        Annonce a2 = new Annonce(2L,"annonce2", "contenu2", 5);
        a2.setCategories(c2);
        a2.setType(OFFRE);
        Utilisateur u2=new Utilisateur();
        u2.setEmail("----------------------");
        Lieu l = new Lieu();
        l.setNom("Bordeaux");
        u2.setLieu(l);
        a2.setUtilisateur(u2);
        lieuService.save(l);
        utilisateurService.save(u2);
        annonceService.save(a2);
        
        Annonce a3 = new Annonce(3L,"annonce3", "contenu3", 5);
        a3.setCategories(c3);
        a3.setType(DEMANDE);
        annonceService.save(a3);
        
//        List<Annonce> liste= new ArrayList<>();
//        liste = annonceService.findByCategoriesAndTypeOrderByTitreAsc(c1, OFFRE);
//        System.out.println(liste);
//        
//        List<Annonce> liste= new ArrayList<>();
//        liste = annonceService.findByTitreAndTypeOrderByTitreAsc("annonce2", OFFRE);
//        System.out.println(liste);
//        
//        List<Annonce> liste= new ArrayList<>();
//        liste = annonceService.findByTypeOrderByTitreAsc(OFFRE);
//        System.out.println(liste);
        
//        List<Annonce> liste= new ArrayList<>();
//        liste = annonceService.findByUtilisateurAndTypeOrderByTitreAsc(u, OFFRE);
//        System.out.println(liste);
        
        List<Annonce> liste= new ArrayList<>();
        liste = annonceService.findByUtilisateurLieuAndTypeOrderByTitreAsc(l, OFFRE);
        System.out.println(liste);

    }
    
    
}
