package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String getAllBooks(Model model) {

        Iterable<Book> all = bookRepository.findAll();
        model.addAttribute("books", all);

        return "book/list";
    }

}
