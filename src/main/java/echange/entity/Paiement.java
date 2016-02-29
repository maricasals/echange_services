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
public class Paiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Long montant;
    private Timestamp dataCreation;
    
    @ManyToOne
    @JoinColumn(name = "PAIEMENT_RECU")
    private Utilisateur destinatairePaiement;
    
    @ManyToOne
    @JoinColumn(name = "PAYEMENT_EMIS")
    private Utilisateur emeteurPaiement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMontant() {
        return montant;
    }

    public void setMontant(Long montant) {
        this.montant = montant;
    }

    public Timestamp getDataCreation() {
        return dataCreation;
    }

    public void setDataCreation(Timestamp dataCreation) {
        this.dataCreation = dataCreation;
    }

    public Utilisateur getDestinatairePaiement() {
        return destinatairePaiement;
    }

    public void setDestinatairePaiement(Utilisateur destinatairePaiement) {
        this.destinatairePaiement = destinatairePaiement;
    }

    public Utilisateur getEmeteurPaiement() {
        return emeteurPaiement;
    }

    public void setEmeteurPaiement(Utilisateur emeteurPaiement) {
        this.emeteurPaiement = emeteurPaiement;
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
        if (!(object instanceof Paiement)) {
            return false;
        }
        Paiement other = (Paiement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "echange.entity.Paiement[ id=" + id + " ]";
    }
    
}
