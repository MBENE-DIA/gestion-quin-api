package ut.set.sn.modeles;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.*;



/**
 
 * @author MBENE DIA
 */
@Entity
@Table(name = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private int telephone;
    
    /*@JoinColumn(name = "employer", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employer employer;*/
    @OneToOne
	private UserModel user;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private Collection<Commande> commandeCollection;*/
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
	private List<Commande> commandes = new ArrayList<>();*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Collection<Commande> commandeCollection;


    public Collection<Commande> getCommandeCollection() {
		return commandeCollection;
	}
	public void setCommandeCollection(Collection<Commande> commandeCollection) {
		this.commandeCollection = commandeCollection;
	}
	public Client() {
    	super();
    }
    public Client(Long id, String nom, String prenom, String adresse, int telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	
	
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

    
}
