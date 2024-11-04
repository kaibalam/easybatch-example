package com.ericsson.crm.commons;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, ID extends Serializable>{
	
	T save(T entity);
	
	List<T> saveAll(List<T> entities);
	
	void delete(ID id);
	
	T get(ID id);
	
	List<T> getAll();
}
