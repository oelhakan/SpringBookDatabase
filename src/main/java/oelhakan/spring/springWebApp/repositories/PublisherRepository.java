package oelhakan.spring.springWebApp.repositories;

import oelhakan.spring.springWebApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
