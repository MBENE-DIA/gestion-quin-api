package ut.set.sn.modeles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "gerant")
public class Gerant {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private int telephone;
    @OneToOne
	private UserModel user;
    
    public Gerant() {
		super();
		// TODO Auto-generated constructor stub
	}
    public Gerant(Long id, String nom, String prenom, int telephone){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
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
