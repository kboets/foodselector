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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import foodselector.domain.enums.FishType;

@Entity
@Table(name="FISH_ORIGIN")
public class FishOrigin extends AbstractEntity {

	private static final long serialVersionUID = -8904553120835097719L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="FISH_ORIGIN_ID")
	private Long id;	
	
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="INFO")
	private String info;
	
	@Column(name="FISH_TYPE", nullable=false)
	@Enumerated(EnumType.STRING)
	private FishType fishType;

	@OneToMany(mappedBy="fishOrigin", fetch=FetchType.EAGER)
	private Set<Fish> fishs;

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

	public FishType getFishType() {
		return fishType;
	}

	public void setFishType(FishType fishType) {
		this.fishType = fishType;
	}

	public Set<Fish> getFishs() {
		return fishs;
	}

	public void setFishs(Set<Fish> fishs) {
		this.fishs = fishs;
	}
}
