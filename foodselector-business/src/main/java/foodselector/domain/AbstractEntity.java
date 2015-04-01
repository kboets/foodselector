package foodselector.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8972754614583384808L;
	
}
