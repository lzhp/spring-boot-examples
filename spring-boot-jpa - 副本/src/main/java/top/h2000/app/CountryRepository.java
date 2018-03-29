package top.h2000.app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {
  
  // @Cacheable("country")
  //Iterable<Country> findAll();
  
  Iterable<Country> findByDescription(String desc);
  
  //Iterable<Country> findByDescriptionAndCode(String desc, String code);

}

