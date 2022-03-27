package oelhakan.spring.springWebApp.repositories;

import oelhakan.spring.springWebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
