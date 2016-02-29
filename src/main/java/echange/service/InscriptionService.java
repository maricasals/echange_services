/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echange.service;

import echange.entity.Utilisateur;
import echange.exception.ExceptionUtilisateurInexistant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class InscriptionService {
    @Autowired
    private UtilisateurService utilisateurService;
    
    public void insciption(Utilisateur u) throws ExceptionUtilisateurInexistant{
        Iterable <Utilisateur> ListeUtil = utilisateurService.findAll();
        for (Utilisateur ut : ListeUtil)
            if (ut.getEmail().equals(u.getEmail()))
                throw new ExceptionUtilisateurInexistant("Adresse e-mail déja utilisé !");
        utilisateurService.save(u);
        }
}
