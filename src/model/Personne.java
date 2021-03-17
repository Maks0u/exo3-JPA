package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the personnes database table.
 * 
 */
@Entity
@Table(name = "personnes")
@NamedQueries({
	@NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p"),
	@NamedQuery(name = "Personne.findById", query = "SELECT p FROM Personne p WHERE p.id = :id")
})
public class Personne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nom;

//	Constructors

	public Personne() {
		super();
	}

	public Personne(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

//	Get Set

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

//	Override methods

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + "]";
	}

}