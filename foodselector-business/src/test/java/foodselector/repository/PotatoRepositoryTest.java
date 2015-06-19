package foodselector.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import foodselector.domain.Potato;

public class PotatoRepositoryTest extends AbstractBasePersistenceTest {

		@Autowired
		private PotatoRepository potatoRepository;
	
		@Test
		public void shouldReturnRosti() {
			Potato potato = potatoRepository.findByDescriptionCode("potato.rosti");
			assertThat(potato, notNullValue());
		}
}
