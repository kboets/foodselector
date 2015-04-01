package foodselector.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import foodselector.domain.Fish;

public class FishRepositoryTest extends AbstractBasePersistenceTest {

	@Autowired
	private FishRepository objectUnderTest;
	@Autowired
	private FishOriginRepository fishOriginRepository;
	
	@Test
	public void findByOriginShouldReturnOneResult() {		
		List<Fish> result = objectUnderTest.findByFishOrigin(fishOriginRepository.findByName("ZALM"));
		assertThat(result, hasSize(1));
	}
	@Test
	public void findByOriginShouldReturnTwoResult() {		
		List<Fish> result = objectUnderTest.findByFishOrigin(fishOriginRepository.findByName("KABELJAUW"));
		assertThat(result, hasSize(2));
	}
	@Test
	public void findByNameShouldReturnOneResult() {		
		Fish fish = objectUnderTest.findByName("fishstick");
		assertThat(fish.getName(), equalTo("fishstick"));
	}
}
