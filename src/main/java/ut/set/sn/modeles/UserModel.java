package ut.set.sn.modeles;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "user_model")
public class UserModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime creatAt;

	private String role;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private Gerant gerant;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private Client client;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private Employer emp;
	// ...
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Gerant> gerantCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Client> clientCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Employer> clientEmployer*/;

    
	/*
	 * @OneToOne(cascade = CascadeType.ALL, mappedBy = "user") private Gerant
	 * gerant;
	 */

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(Long id) {
		this.id = id;
	}
	
	public UserModel(String email, String password, LocalDateTime creatAt, String role) {
		super();
		this.email = email;
		this.password = password;
		this.creatAt = creatAt;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getCreatAt() {
		return creatAt;
	}

	public void setCreatAt(LocalDateTime creatAt) {
		this.creatAt = creatAt;
	}

	


	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

