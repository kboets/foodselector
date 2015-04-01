package foodselector.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VEGETABLES")
public class Vegetables extends AbstractEntity {
	
	private static final long serialVersionUID = -6955641106993033485L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="VEGETABLES_ID")
	private Long id;	
	
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="INFO")
	private String info;

	@ManyToOne
	@JoinColumn(name="id")
	private VegetablesFamily vegetablesFamily;

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

	public VegetablesFamily getVegetablesFamily() {		
		return vegetablesFamily;
	}

	public void setVegetablesFamily(VegetablesFamily vegetablesFamily) {
		this.vegetablesFamily = vegetablesFamily;
	}
	
	
}
