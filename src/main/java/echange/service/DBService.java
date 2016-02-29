/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echange.service;

import echange.entity.Annonce;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class DBService{
    
//    @PersistenceContext
//    private EntityManager em;
    
    @Autowired
    private AnnonceService annonceService;
    
    @Autowired
    private CategorieService categorieService;
    
    @Autowired
    private CommentaireService commentaireService;
    
    @Autowired
    private LieuService lieuService;
    
    @Autowired
    private MessageService messageService;
    
    @Autowired
    private PaiementService paiementService;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    
    public void supprimerTout(){
        commentaireService.deleteAll();
        annonceService.deleteAll();
        messageService.deleteAll();
        paiementService.deleteAll();
        utilisateurService.deleteAll();
        lieuService.deleteAll();
        categorieService.deleteAll();
    }

}
