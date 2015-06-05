package foodselector.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.context.MessageSource;

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
	
	@Transient
	private List<DishAdditive> dishAdditives;
	
	 
	
	@ManyToOne
	@JoinColumn(name="dish_potato_id")
	private Potato potato;
	
	@ManyToOne
	@JoinColumn(name="dish_pasta_id")
	private Pasta pasta; 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DishAdditive> getDishAdditives() {
		return dishAdditives;
	}

	public void setDishAdditives(List<DishAdditive> dishAdditives) {		
		this.dishAdditives = dishAdditives;
	}

	public Long getId() {
		return id;
	}

	public Potato getPotato() {
		return potato;
	}

	public void setPotato(Potato potato) {
		this.potato = potato;
	}

	public Pasta getPasta() {
		return pasta;
	}

	public void setPasta(Pasta pasta) {
		this.pasta = pasta;
	}
}
