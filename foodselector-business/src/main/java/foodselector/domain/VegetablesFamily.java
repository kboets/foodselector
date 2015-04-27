package foodselector.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="VEGETABLES_FAMILY")
public class VegetablesFamily extends AbstractEntity {

	private static final long serialVersionUID = -8172432978481554285L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="VEGETABLES_FAMILY_ID")
	private Long id;
	
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="INFO")
	private String info;
	
	@OneToMany(mappedBy="vegetablesFamily", fetch=FetchType.EAGER)	
	private Set<Vegetables> vegetables;
	
	public Long getId() {
		return id;
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

	public Set<Vegetables> getVegetables() {
		if(vegetables == null){
			vegetables = new HashSet<Vegetables>();
		}
		return vegetables;
	}
	

	public void setVegetables(Set<Vegetables> vegetables) {
		this.vegetables = vegetables;
	}
	
	public void addVegetables(Vegetables vegetables) {
		this.getVegetables().add(vegetables);
		vegetables.setVegetablesFamily(this);
	}
}
