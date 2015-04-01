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
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="MEAT")
public class Meat extends AbstractEntity {

	
	private static final long serialVersionUID = -5683425838134147067L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="MEAT_ID")
	private Long id;	
	
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="INFO")
	private String info;
	
	@ManyToMany	(fetch=FetchType.EAGER)
	@JoinTable(name="MEAT_MEATORIGINS", 
		joinColumns=@JoinColumn(name="MEAT_ID"), 
		inverseJoinColumns=@JoinColumn(name="MEAT_ORIGIN_ID"))
	private Set<MeatOrigin> meatOrigins;

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

	public Set<MeatOrigin> getMeatOrigins() {
		return meatOrigins;
	}

	public void setMeatOrigins(Set<MeatOrigin> meatOrigins) {
		this.meatOrigins = meatOrigins;
	}
}
