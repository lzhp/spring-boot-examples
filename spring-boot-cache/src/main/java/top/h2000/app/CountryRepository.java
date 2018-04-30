package top.h2000.app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {

  Iterable<Country> findAll();
  Country findByCode(String code);
}

