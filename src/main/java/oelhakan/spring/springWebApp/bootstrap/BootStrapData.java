package oelhakan.spring.springWebApp.bootstrap;

import oelhakan.spring.springWebApp.domain.Author;
import oelhakan.spring.springWebApp.domain.Book;
import oelhakan.spring.springWebApp.domain.Publisher;
import oelhakan.spring.springWebApp.repositories.AuthorRepository;
import oelhakan.spring.springWebApp.repositories.BookRepository;
import oelhakan.spring.springWebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher relx = new Publisher("RELX", "230 Park Avenue", "New York", "NY 10169");
        Publisher thomsonReuters = new Publisher("Thomson Reuters", "530 Fifth Avenue", "New York", "NY 10017");

        publisherRepository.save(relx);
        publisherRepository.save(thomsonReuters);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author mario = new Author("Mario Puzzo");
        Book theGodFather = new Book("The Godfather", "0399103422");
        mario.getBooks().add(theGodFather);
        theGodFather.getAuthors().add(mario);

        Author jkrowling = new Author("J.K. Rowling");
        Book philosophersStone = new Book("Philosopher's Stone", "9781408855652");
        jkrowling.getBooks().add(philosophersStone);
        philosophersStone.getAuthors().add(jkrowling);

        philosophersStone.setPublisher(relx);
        relx.getBooks().add(philosophersStone);

        theGodFather.setPublisher(thomsonReuters);
        thomsonReuters.getBooks().add(theGodFather);

        authorRepository.save(jkrowling);
        authorRepository.save(mario);
        bookRepository.save(theGodFather);
        bookRepository.save(philosophersStone);
        publisherRepository.save(relx);
        publisherRepository.save(thomsonReuters);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Number of Books Published by " + relx.getName() + " : " + relx.getBooks().size());
        System.out.println("Number of Books Published by " + thomsonReuters.getName() + " : " + thomsonReuters.getBooks().size());
    }
}
