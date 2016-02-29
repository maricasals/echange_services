/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echange.entity;

import java.io.Serializable;
import java.security.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author admin
 */
@Entity
public class Commentaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String contenu;
    private Integer note;
    private Timestamp dateCreation;
    
    @ManyToOne
    @JoinColumn(name = "UTILISATEUR")
    private Utilisateur commentairePoste;
    
    @ManyToOne
    @JoinColumn(name = "ANNONCE")
    private Annonce commentaireAnnonce;

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getCommentairePoste() {
        return commentairePoste;
    }

    public void setCommentairePoste(Utilisateur commentairePoste) {
        this.commentairePoste = commentairePoste;
    }

    public Annonce getCommentaireAnnonce() {
        return commentaireAnnonce;
    }

    public void setCommentaireAnnonce(Annonce commentaireAnnonce) {
        this.commentaireAnnonce = commentaireAnnonce;
    }

    public Commentaire(String contenu) {
        this.contenu = contenu;
    }

    public Commentaire() {
    }
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commentaire)) {
            return false;
        }
        Commentaire other = (Commentaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "echange.entity.Commentaire[ id=" + id + " ]";
    }
    
}
