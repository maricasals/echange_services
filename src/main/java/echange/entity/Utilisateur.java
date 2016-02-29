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
    
    @OneToMany(mappedBy = "utilisateur")
    private List<Annonce> annonces = new ArrayList<>();
    
    @OneToMany(mappedBy = "emeteurMessage")
    private List<Message> messagesPostes = new ArrayList<>();
    
    @OneToMany(mappedBy = "destinataireMessage")
    private List<Message> messagesReçu = new ArrayList<>();
    
    @OneToMany(mappedBy = "emeteurPaiement")
    private List<Paiement> paiementEmis = new ArrayList<>();
    
    @OneToMany(mappedBy = "destinatairePaiement")
    private List<Paiement> paiementReçu = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "LIEUX")
    private Lieu lieu;
    
    @OneToMany(mappedBy = "commentairePoste")
    private List<Commentaire> commentaires;
    
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

    public List<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }

    public List<Message> getMessagesPostes() {
        return messagesPostes;
    }

    public void setMessagesPostes(List<Message> messagesPostes) {
        this.messagesPostes = messagesPostes;
    }

    public List<Message> getMessagesReçu() {
        return messagesReçu;
    }

    public void setMessagesReçu(List<Message> messagesReçu) {
        this.messagesReçu = messagesReçu;
    }

    public List<Paiement> getPaiementEmis() {
        return paiementEmis;
    }

    public void setPaiementEmis(List<Paiement> paiementEmis) {
        this.paiementEmis = paiementEmis;
    }

    public List<Paiement> getPaiementReçu() {
        return paiementReçu;
    }

    public void setPaiementReçu(List<Paiement> paiementReçu) {
        this.paiementReçu = paiementReçu;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public TypeUtil getType() {
        return type;
    }

    public void setType(TypeUtil type) {
        this.type = type;
    }

    public Integer getSolde() {
        return solde;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }

    public Utilisateur(Lieu lieu, List<Commentaire> commentaires, String email, String mdp, TypeUtil type, Integer solde) {
        this.lieu = lieu;
        this.commentaires = commentaires;
        this.email = email;
        this.mdp = mdp;
        this.type = type;
        this.solde = solde;
    }

    public Utilisateur() {
    }
    
    
}
