/*import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="commande")
public class Commande {
   
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private Boolean etat;
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate date;
	   private UserModel user;
		private Integer livraison;
		private Integer client;
		private String typePaiement;
	 @JoinColumn(name = "user", referencedColumnName = "id")
	  @ManyToOne(optional = false)	
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable
	Set<Produit> produit = new HashSet<>();
	
	
	
	public Commande() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Commande(Boolean et, LocalDate d, Integer liv, Integer cl, String type) {
		super();
		this.etat = et;
		this.date = d;
		this.livraison = liv;
		this.client = cl;
		this.typePaiement = type;
		
		
	}
	@Override
	public String toString() {
		return "Commande [id=" + id + ", etat=" + etat + ", date=" + date + ", user=" + user + ", livraison="
				+ livraison + ", client=" + client + ", typePaiement=" + typePaiement + ", produit=" + produit + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Integer getLivraison() {
		return livraison;
	}
	public void setLivraison(Integer livraison) {
		this.livraison = livraison;
	}
	public Integer getClient() {
		return client;
	}
	public void setClient(Integer client) {
		this.client = client;
	}
	public String getTypePaiement() {
		return typePaiement;
	}
	public void setTypePaiement(String typePaiement) {
		this.typePaiement = typePaiement;
	}*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ut.set.sn.modeles;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *
 * @author MBENE DIA
 */
@Entity
@Table(name = "commande")

public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private int quantiteTotal;
     private int totale;
    @JsonFormat(pattern="dd/MM/yyyy")
  	private LocalDate date;
    private Short etat;
    private String typePaiement;
    @JoinColumn(name = "client", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "livraison", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Livraison livraion;
	@JoinColumn(name = "produit", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produit produit;
    
    public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Livraison getLivraion() {
		return livraion;
	}

	public void setLivraion(Livraison livraion) {
		this.livraion = livraion;
	}


    
    
    
    
    public Commande() {
    	super();
    }

    public Commande(Long id) {
        this.id = id;
    }

    public Commande(Long id, int quantiteTotal, int totale, LocalDate date) {
        this.id = id;
        this.quantiteTotal = quantiteTotal;
        this.totale = totale;
        this.date = date;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantiteTotal() {
		return quantiteTotal;
	}

	public void setQuantiteTotal(int quantiteTotal) {
		this.quantiteTotal = quantiteTotal;
	}

	public int getTotale() {
		return totale;
	}

	public void setTotale(int totale) {
		this.totale = totale;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Short getEtat() {
		return etat;
	}

	public void setEtat(Short etat) {
		this.etat = etat;
	}

	public String getTypePaiement() {
		return typePaiement;
	}

	public void setTypePaiement(String typePaiement) {
		this.typePaiement = typePaiement;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
}

	

