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
	@ManyToMany	
	@JoinTable(name="DISH_VEGETABLES", 
		joinColumns=@JoinColumn(name="DISH_ID"), 
		inverseJoinColumns=@JoinColumn(name="VEGETABLES_ID"))
	private List<Vegetables> vegetables;	
	@Transient
	private DishAdditive additiveToChoose;	
	@Transient
	private DishAdditive pickedAdditive;	
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

	public DishAdditive getPickedAdditive() {
		return pickedAdditive;
	}

	public void setPickedAdditive(DishAdditive pickedAdditive) {		
		this.pickedAdditive = pickedAdditive;
		if(pickedAdditive instanceof Pasta) {
			setPasta((Pasta) pickedAdditive);
		} else if(pickedAdditive instanceof Potato) {
			setPotato((Potato) pickedAdditive);
		}
	}

	public DishAdditive getAdditiveToChoose() {
		return additiveToChoose;
	}

	public void setAdditiveToChoose(DishAdditive additiveToChoose) {		
		this.additiveToChoose = additiveToChoose;
		if(pickedAdditive instanceof Potato) {
			setPickedAdditive(additiveToChoose);
		}
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

	public List<Vegetables> getVegetables() {
		return vegetables;
	}

	public void setVegetables(List<Vegetables> vegetables) {
		this.vegetables = vegetables;
	}
}
