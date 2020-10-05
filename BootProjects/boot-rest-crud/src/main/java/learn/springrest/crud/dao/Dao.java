package learn.springrest.crud.dao;

import java.util.List;
import java.util.Optional;

// Define a basic DAO layer, so we can see how it can keep the domain model completely decoupled from the persistence layer.
public interface Dao<T>	 {
	
	//Optional<T> get(long id);
    
    List<T> getAll();
    
    void save(T t);
    
   // void update(T t, String[] params);
    
    //void delete(T t);
}
