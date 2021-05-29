package ut.set.sn.modeles;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 *
 * @author MBENE DIA
 */
@Entity
@Table(name = "employer")
public class Employer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
     private String prenom;
     private int telephone;
     private int age;
     private String adrese;
     private String genre;
     private String SituationMatrimonial;
    @JsonFormat(pattern="dd/MM/yyyy")
   	private LocalDate dateRecrutement;
      
     @OneToOne
 	 private UserModel user;
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "employer", fetch = FetchType.LAZY)
     private Collection<Livraison> livraisonCollection;
    
    public Employer() {
    	super();
    }

    public Employer(Long id) {
        this.id = id;
  }
    
        

	public Employer(String nom, String prenom, int telephone, int age, String adrese, String genre,
			String situationMatrimonial, LocalDate dateRecrutement, UserModel user,
			Collection<Livraison> livraisonCollection) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.age = age;
		this.adrese = adrese;
		this.genre = genre;
		SituationMatrimonial = situationMatrimonial;
		this.dateRecrutement = dateRecrutement;
		this.user = user;
		this.livraisonCollection = livraisonCollection;
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
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAdrese() {
		return adrese;
	}

	public void setAdrese(String adrese) {
		this.adrese = adrese;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSituationMatrimonial() {
		return SituationMatrimonial;
	}

	public void setSituationMatrimonial(String situationMatrimonial) {
		SituationMatrimonial = situationMatrimonial;
	}

	public LocalDate getDateRecrutement() {
		return dateRecrutement;
	}

	public void setDateRecrutement(LocalDate dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}

//	public Collection<Livraison> getLivraisonCollection() {
//		return livraisonCollection;
//	}
//
//	public void setLivraisonCollection(Collection<Livraison> livraisonCollection) {
//		this.livraisonCollection = livraisonCollection;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

   
}

