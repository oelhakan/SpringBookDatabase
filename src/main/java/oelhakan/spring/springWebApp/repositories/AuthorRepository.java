package oelhakan.spring.springWebApp.repositories;

import oelhakan.spring.springWebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
