package foodselector.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import foodselector.domain.enums.Availability;

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
	
	@Column(name="INFO", columnDefinition="CLOB")
	private String info;

	@ManyToOne
	@JoinColumn(name="vegetables_vf_id")
	private VegetablesFamily vegetablesFamily;

	@Enumerated(EnumType.STRING)
	@Column(name="AVAILABILITY")
	private Availability availability;
	
	
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

	public VegetablesFamily getVegetablesFamily() {		
		return vegetablesFamily;
	}

	public void setVegetablesFamily(VegetablesFamily vegetablesFamily) {
		this.vegetablesFamily = vegetablesFamily;
	}

	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((availability == null) ? 0 : availability.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Vegetables other = (Vegetables) obj;
		if (availability != other.availability)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
