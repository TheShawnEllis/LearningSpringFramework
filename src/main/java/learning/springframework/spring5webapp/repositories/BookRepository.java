package learning.springframework.spring5webapp.repositories;

import learning.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

// LEARNING: Spring data repositories are interfaces for managing entities with CRUD operations queries, sorting and pagination, transaction and abstraction.
//  Book is extend from CRUDRepository because of the built in methods for create, delete, update, and locate.
public interface BookRepository extends CrudRepository<Book, Long> {
}
