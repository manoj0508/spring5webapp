package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

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

        System.out.println("Started in bootStrap");
        System.out.println("Number of books saved in DB: " + bookRepository.count());

    }
}
