package foodselector.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import foodselector.domain.enums.MeatType;

@Entity
@Table(name="MEAT_ORIGIN")
public class MeatOrigin extends AbstractEntity {
	
	private static final long serialVersionUID = -4317270604227244626L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="MEAT_ORIGIN_ID")
	private Long id;	
	
	@Column(name="NAME", nullable=false, unique=true)	
	private String name;
	
	@Column(name="MEAT_TYPE", nullable=false)
	@Enumerated(EnumType.STRING)
	private MeatType meatType;
	
	@Column(name="INFO")
	private String info;

	@ManyToMany(mappedBy="meatOrigins", fetch=FetchType.EAGER)
	@OrderBy("name")
	private Set<Meat> meatSet;
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MeatType getMeatType() {
		return meatType;
	}

	public void setMeatType(MeatType meatType) {
		this.meatType = meatType;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Set<Meat> getMeatSet() {
		return meatSet;
	}

	public void setMeatSet(Set<Meat> meatSet) {
		this.meatSet = meatSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result
				+ ((meatType == null) ? 0 : meatType.hashCode());
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
		MeatOrigin other = (MeatOrigin) obj;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (meatType != other.meatType)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
