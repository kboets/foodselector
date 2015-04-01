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
@Table(name="FISH")
public class Fish extends AbstractEntity {

	
	private static final long serialVersionUID = -3322283583516590632L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="FISH_ID")
	private Long id;
	
	@Column(name="NAME", nullable=false, unique=true)
	private String name;
	
	@Column(name="INFO")
	private String info;
	
	@ManyToOne
	@JoinColumn(name="fish_fishOrigin_id")	
	private FishOrigin fishOrigin;

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

	public FishOrigin getFishOrigin() {
		return fishOrigin;
	}

	public void setFishOrigin(FishOrigin fishOrigin) {
		this.fishOrigin = fishOrigin;
	}
}
