package foodselector.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DISH")
public class Dish extends AbstractEntity {

	private static final long serialVersionUID = 5188630286563539506L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="DISH_ID")
	private Long id;
	
	@Column(name="NAME", nullable=false, unique=true)
	private String name;
	
}
