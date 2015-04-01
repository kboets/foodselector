package foodselector.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

import foodselector.domain.Meat;

//@DatabaseSetup("MeatRepositoryTest.xml")
public class MeatRepositoryTest extends AbstractBasePersistenceTest {

	@Autowired
	private MeatRepository meatRepository;
	@Autowired 
	private MeatOriginRepository meatOriginRepository;
	
	@Test
	public void meat_has_one_meatOriginTypes() {
		Meat meat=meatRepository.findByName("Kippenworst");
		assertThat(meat, is(notNullValue()));
		assertThat(meat.getMeatOrigins(), hasSize(1));		
	}
	
	@Test
	public void meat_has_two_meatOriginTypes() {
		Meat meat=meatRepository.findByName("Kippenworst");
		assertThat(meat, is(notNullValue()));
		assertThat(meat.getMeatOrigins(), hasSize(1));		
	}
	@Test
	public void totalMeat() {
		Iterable<Meat> iterable = meatRepository.findAll();
		System.out.println("SIZE " +Lists.newArrayList(iterable));
	}
	
	
	
	
}
