package foodselector.service;

import java.io.Serializable;
import java.util.List;
/** 
 * AbstractService , used as a base for all services.
 * Included is the complete CRUD, created interface so that each
 * service can have it's own implementation of the same function.
 * 
 *  T : Entity which will be returned. 
 *  U : Class of the identifier of the entity which should be Serializable
 * 
 * **/
public interface IAbstractService <T, U extends Serializable> {
	
	/**
	 * Retrieves all entities.
	 * @return
	 */
	List<T> getAll();
	/**
	 * Saves or updates the entity.
	 * @param entity 
	 * @return
	 */
	T save(T entity);
	/**
	 * Retrieves the unique entity.
	 * @param id - the unique id.
	 * @return entity
	 */
	T getById(Long id);
	/**
	 * Deletes the entity.
	 * @param entity
	 */
	void delete(T entity);
	
}
