package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Address;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AddressRepository;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final AddressRepository addressRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, AddressRepository addressRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.addressRepository = addressRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Address address = new Address("line1", "Chitarpur", "Jharkhand", 825101);
        Publisher publisher = new Publisher("Book publisher ltd");

        publisher.getAddresses().add(address);
        addressRepository.save(address);



        Author manoj = new Author("Manoj", "Kumar");
        Book java = new Book("Java beginer", "M784566");
        manoj.getBooks().add(java);
        java.getAuthors().add(manoj);

        authorRepository.save(manoj);
        bookRepository.save(java);

        Author arun = new Author("Arun", "Kumar");
        Book python = new Book("Python beginer", "A784566");
        manoj.getBooks().add(python);
        java.getAuthors().add(arun);

        authorRepository.save(arun);
        bookRepository.save(python);

        publisher.getBooks().add(java);
        publisher.getBooks().add(python);
        publisherRepository.save(publisher);

        System.out.println("Started in bootStrap");
        System.out.println("Number of books saved in DB: " + bookRepository.count());

        System.out.println("Number of publisher saved in DB: " + publisherRepository.count());

    }
}
