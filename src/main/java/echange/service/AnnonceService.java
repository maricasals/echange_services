/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echange.service;

import echange.entity.Annonce;
import echange.entity.Categorie;
import echange.entity.EnumAnnonce;
import echange.entity.Lieu;
import echange.entity.Utilisateur;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface AnnonceService extends CrudRepository<Annonce, Long>{
    
    public List<Annonce> findByCategoriesAndTypeOrderByTitreAsc(Categorie categorie, EnumAnnonce type);
    
    public List<Annonce> findByTitreAndTypeOrderByTitreAsc(String titre, EnumAnnonce type);
    
    public List<Annonce> findByTypeOrderByTitreAsc(EnumAnnonce type);
    
    public List<Annonce> findByUtilisateurAndTypeOrderByTitreAsc(Utilisateur u, EnumAnnonce type);
    
    public List<Annonce> findByUtilisateurLieuAndTypeOrderByTitreAsc(Lieu lieu, EnumAnnonce type);
    
}
