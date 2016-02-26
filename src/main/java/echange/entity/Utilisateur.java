/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echange.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author admin
 */
@Entity
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany(mappedBy = "annonces")
    private List<Annonce> annonces = new ArrayList<>();
    
    @OneToMany(mappedBy = "emeteur")
    private List<Message> messagesPostes = new ArrayList<>();
    
    @OneToMany(mappedBy = "destinataire")
    private List<Message> messagesReçu = new ArrayList<>();
    
    @OneToMany(mappedBy = "emeteur")
    private List<Paiement> paiementEmis = new ArrayList<>();
    
    @OneToMany(mappedBy = "destinataire")
    private List<Paiement> paiementReçu = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "utilisateur")
    private Lieu lieu;
    
    @Column(unique = true)
    private String email;
    
    private String mdp;
    
    private  TypeUtil type;
    private Integer solde;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "echange.entity.Utilisateur[ id=" + id + " ]";
    }
    
}
