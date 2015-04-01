package foodselector.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import foodselector.domain.Meat;
import foodselector.domain.MeatOrigin;
import foodselector.domain.enums.MeatType;
import foodselector.repository.MeatOriginRepository;


//@DatabaseSetup("MeatOriginRepositoryTest.xml")
public class MeatOriginRepositoryTest extends AbstractBasePersistenceTest {

	@Autowired
	private MeatOriginRepository meatOriginRepo;
	
	@Test
	public void is_initialised() {
		assertThat(meatOriginRepo, is(notNullValue()));
	}
	
	@Test
	public void findByMeatType_white_size() {
		List<MeatOrigin> result = meatOriginRepo.findByMeatType(MeatType.WHITE);
		assertThat(result, hasSize(2));
	}
	@Test
	public void findById() {
		MeatOrigin origin = meatOriginRepo.findOne(1L);
		assertThat(origin, is(notNullValue()));
		assertThat(origin.getId(), is(equalTo(1L)));		
	}
	@Test
	public void findByName() {
		MeatOrigin origin = meatOriginRepo.findByName("VARKEN");
		assertThat(origin, notNullValue());
		
	}
	
	@Test
	public void findAll() {
		Iterable <MeatOrigin> result = meatOriginRepo.findAll();		
		assertThat(result, is(notNullValue()));
		for (MeatOrigin meatOrigin : result) {
			Set<Meat> meats = meatOrigin.getMeatSet();
			for (Iterator iterator = meats.iterator(); iterator.hasNext();) {
				Meat meat = (Meat) iterator.next();
				System.out.println(meatOrigin.getName() +" meat: "+meat.getName());
			}
			
		}
	}
	
	@Test
	public void update_name() {
		MeatOrigin origin = meatOriginRepo.findOne(1L);		
		assertThat(origin.getName(), is(equalTo("VARKEN")));
		origin.setName("varkensvlees");
		meatOriginRepo.save(origin);
		MeatOrigin result = meatOriginRepo.findOne(1L);
		assertThat(result.getName(), is(equalTo("varkensvlees")));
	}
	
	
}
