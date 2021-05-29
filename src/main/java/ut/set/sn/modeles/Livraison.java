package ut.set.sn.modeles;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *
 * @author MBENE DIA
 */
@Entity
@Table(name = "livraison")
public class Livraison  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
    @Basic(optional = false)
    @JsonFormat(pattern="dd/MM/yyyy")
  	private LocalDate date;
    private String lieu;
    
    @JoinColumn(name = "employer", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employer employer;
    
    public Livraison(LocalDate date, String lieu, Employer employer) {
		super();
		this.date = date;
		this.lieu = lieu;
		this.employer = employer;
	}

	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "livraison")
    private Collection<Commande> commandeCollection;
*/

	public Livraison() {
    }

    public Livraison(Long id) {
        this.id = id;
    }

    
    
    

   
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	/*public Collection<Commande> getCommandeCollection() {
		return commandeCollection;
	}

	public void setCommandeCollection(Collection<Commande> commandeCollection) {
		this.commandeCollection = commandeCollection;
	}*/
	

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livraison)) {
            return false;
        }
        Livraison other = (Livraison) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}

