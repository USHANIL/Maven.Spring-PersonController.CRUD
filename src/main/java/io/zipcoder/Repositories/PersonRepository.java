package io.zipcoder.Repositories;

import io.zipcoder.Models.Person;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface PersonRepository extends  CrudRepository<Person, Long> {


}
