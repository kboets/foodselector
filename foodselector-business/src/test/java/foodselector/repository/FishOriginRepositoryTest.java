package foodselector.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import foodselector.domain.FishOrigin;
import foodselector.domain.enums.FishType;

public class FishOriginRepositoryTest extends AbstractBasePersistenceTest {

	@Autowired
	private FishOriginRepository objectUnderTest;	
	
	@Test
	public void shouldReturnOneFishOrigin() {
		List<FishOrigin> result = objectUnderTest.findByFishType(FishType.WHITE);
		assertThat(result, hasSize(1));
	}
	
	@Test
	public void shouldReturnTwoFishOrigin() {
		List<FishOrigin> result = objectUnderTest.findByFishType(FishType.OILY);
		assertThat(result, hasSize(2));
	}
}
