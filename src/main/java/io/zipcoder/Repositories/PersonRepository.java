package io.zipcoder.Repositories;

import io.zipcoder.Models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends  CrudRepository<Person, Long> {


}
