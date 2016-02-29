/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echange.service;

import echange.entity.Commentaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
public interface CommentaireService extends CrudRepository<Commentaire, Long>{
    
}
