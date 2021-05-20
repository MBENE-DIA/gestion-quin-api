package ut.set.sn.modeles;

import java.io.Serializable;

import java.util.Collection;


import javax.persistence.*;

@Entity
@Table(name="produit")
public class Produit implements Serializable {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	 
	    private Long id;
	    private String nom;
	    private int prixUnitaire;
	    private int quantite;
	    private String categorie;
	    @Column(name="photo")
	    private String photo;
	   		@Column(name = "type")
	    private String type;
	    @Column(name = "picByte", length = 698362)
	     private byte[] picByte;
	   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "produitId")
	    private Collection<Commande> commandeCollection;*/
	    
	   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
		private List<Commande> commandes = new ArrayList<>();*/
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
	     private Collection<Commande> commandeCollection;
	    
	 

	public Produit() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Produit(String nom, int prix, int qt, String cat ) {
		super();
		this.nom = nom;
		
		this.prixUnitaire = prix;
		this.quantite = qt;
		this.categorie = cat;
		
	}
	 public Collection<Commande> getCommandeCollection() {
			return commandeCollection;
		}

		public void setCommandeCollection(Collection<Commande> commandeCollection) {
			this.commandeCollection = commandeCollection;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
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


	public int getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(int prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	

	
	

}
