package foodselector.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="SPICES")
public class Spices extends AbstractEntity {

	private static final long serialVersionUID = -7471959872777962631L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SPICES_ID")
	private Long id;	
	
	
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="INFO", columnDefinition="CLOB")
	private String info;
	
	@Column(name="USAGE")
	private String usage;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="SPICES_VEGETABLES", 
	joinColumns=@JoinColumn(name="SPICES_ID"), 
	inverseJoinColumns=@JoinColumn(name="VEGETABLES_ID"))
	private Set<Vegetables> favoriteVegetables;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Set<Vegetables> getFavoriteVegetables() {
		return favoriteVegetables;
	}

	public void setFavoriteVegetables(Set<Vegetables> favoriteVegetables) {
		this.favoriteVegetables = favoriteVegetables;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}
	
}
