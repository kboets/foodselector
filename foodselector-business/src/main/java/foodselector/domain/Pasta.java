package foodselector.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="PASTA")
public class Pasta extends AbstractEntity {

	
	private static final long serialVersionUID = 2437161609943460320L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="MEAT_ID")
	private Long id;
	
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="INFO", columnDefinition="CLOB")
	private String info;

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
	
}
