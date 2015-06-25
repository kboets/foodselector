package foodselector.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import foodselector.domain.Potato;
import foodselector.domain.enums.PotatoType;

public class PotatoRepositoryTest extends AbstractBasePersistenceTest {

		@Autowired
		private PotatoRepository potatoRepository;
	
		@Test
		public void shouldReturnRosti() {
			String code = "potato.rosti";
			PotatoType potatoType = PotatoType.findByCode(code);
			assertThat(potatoType, notNullValue());
			Potato potato = potatoRepository.findByPotatoType(potatoType);
			assertThat(potato, notNullValue());
			assertThat(potato.getDescriptionCode(), equalTo(code));
		}
}
