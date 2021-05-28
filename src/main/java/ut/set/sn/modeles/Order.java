package ut.set.sn.modeles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer quantite;
	@OneToOne
	@JoinColumn(name = "user", nullable = false)
	private UserModel user;
	@ManyToOne
	@JoinColumn(name = "produit", nullable = false)
	private Produit produit;
	@CreationTimestamp
	@Column(name = "creationDate", nullable = false, updatable = false)
	private LocalDateTime creationDate;
	@CreationTimestamp
	@Column(name = "updatedDate", nullable = false, updatable = false)
	private LocalDateTime updatedDate;
	
	
	
	public Order(Integer id, Integer quantite, UserModel user, Produit produit, LocalDateTime creationDate,
			LocalDateTime updatedDate) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.user = user;
		this.produit = produit;
		this.creationDate = creationDate;
		this.updatedDate = updatedDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	
	
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", quantite=" + quantite + ", user=" + user + ", produit=" + produit
				+ ", creationDate=" + creationDate + ", updatedDate=" + updatedDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	}
