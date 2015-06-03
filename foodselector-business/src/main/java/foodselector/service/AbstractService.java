package foodselector.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

/**
 * Service will handle all CRUD operations for the specific domain object. 
 * 
 * @author kboets
 *
 * @param <T> - the domain object.
 * @param <U> - the primary key of the domain object.
 */
@Service
public abstract class AbstractService <T, U extends Serializable> implements IAbstractService<T, U> {

	private CrudRepository<T, U> repository;

	public void setRepository(CrudRepository<T, U> repository) {
		this.repository = repository;
	}
	
	@Transactional(readOnly=true)
	public List<T> getAll() {
		Iterable<T> iterable = repository.findAll();
		return Lists.newArrayList(iterable);
	}
	
	@Transactional(readOnly=false)
	public T save(T entity) {		
		return repository.save(entity);
	}
	
	@Transactional(readOnly=true)
	public T getById(U id) {
		return repository.findOne(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(T entity) {
		repository.delete(entity);
	}

}
