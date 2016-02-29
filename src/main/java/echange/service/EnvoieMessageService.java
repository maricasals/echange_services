/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echange.service;

import echange.entity.Message;
import echange.entity.Utilisateur;
import echange.exception.ExceptionUtilisateurInexistant;
import java.sql.Timestamp;
import java.time.Instant;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class EnvoieMessageService {
    
    @PersistenceContext
    private EntityManager em;
    
    @Autowired
    MessageService messageService;
    
    @Autowired
    UtilisateurService utilisateurService;
    
    public void envoieMessage( Long idEmetteur, Long idDestinataire,String titre, String msg) throws ExceptionUtilisateurInexistant{
        // Déclaration des Exceptions si l'utilisateur ou l'emetteur sont inexistants
         if (utilisateurService.exists(idEmetteur)==false){
             throw new ExceptionUtilisateurInexistant();
         }
        if (utilisateurService.exists(idDestinataire)==false){
             throw new ExceptionUtilisateurInexistant();
         }
        //Récupération des emetteur et recepteur
        Utilisateur emetteur = utilisateurService.findOne(idEmetteur);
        Utilisateur destinataire = utilisateurService.findOne(idDestinataire);
        //Création et Edition des attributs du messages
        Message m = new Message();
        m.setEmeteurMessage(emetteur);
        m.setDestinataireMessage(destinataire);
        m.setTitre(titre);
        m.setContenu(msg);  
        m.setLu(false);
        Timestamp date;
        date =  Timestamp.from(Instant.now());
        m.setDateCreation(date);
        //Enregistrement du message
        messageService.save(m);
    }
    
}
