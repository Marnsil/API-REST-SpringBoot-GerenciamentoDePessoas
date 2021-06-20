package digital.InnovationOne.personapi.repository;

import digital.InnovationOne.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {


}
