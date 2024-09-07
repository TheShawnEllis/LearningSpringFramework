package learning.springframework.spring5webapp.bootstrap;

import learning.springframework.spring5webapp.domain.Author;
import learning.springframework.spring5webapp.domain.Book;
import learning.springframework.spring5webapp.domain.Publisher;
import learning.springframework.spring5webapp.repositories.AuthorRepository;
import learning.springframework.spring5webapp.repositories.BookRepository;
import learning.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//LEARNING: The bootstrap class is used to initialize data in the database
//  CommandLineRunner is an interface used to run instances of it when the application is started
//  @Component annotation is used to indicate that the class is a Spring managed component
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    //LEARNING: Constructor injection is used to inject the AuthorRepository and BookRepository
    //  Because the class is annotated with @Component, Spring will automatically inject the dependencies when it calls this constructor
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Author eric = new Author("Eric", "Evans");
        Book ericBook = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ericBook);
        ericBook.getAuthors().add(eric);

        //LEARNING: Save the author and book to the H2 database
        authorRepository.save(eric);
        bookRepository.save(ericBook);

        Author rod = new Author("Rod", "Johnson");
        Book rodBook = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(rodBook);
        rodBook.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(rodBook);

        Publisher thinkPublisher = new Publisher(
                "1234 Main St",
                "Springfield",
                "IL",
                "62701"
        );

        publisherRepository.save(thinkPublisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
    }
}
