package foodselector.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import foodselector.domain.Pasta;

public class PastaRepositoryTest extends AbstractBasePersistenceTest {

	@Autowired
	private PastaRepository pastaRepository;
	
	
}
