package foodselector.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import foodselector.domain.enums.PotatoType;

@Entity
@Table(name="POTATO")
public class Potato extends AbstractEntity implements DishAdditive{

	/**	 *	 */
	private static final long serialVersionUID = 6862404299910770831L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="POTATO_ID")
	private Long id;
	
	@Column(name="POTATO_TYPE", nullable=false)
	@Enumerated(EnumType.STRING)
	private PotatoType potatoType;
	 
		
	public Long getId() {
		return id;
	}
	
	public PotatoType getPotatoType() {
		return potatoType;
	}

	public void setPotatoType(PotatoType potatoType) {
		this.potatoType = potatoType;
	}	
	
	@Override
	public String getDescriptionCode() {
		return potatoType.getCode();
	}
	
}
