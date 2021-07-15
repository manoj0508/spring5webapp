package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorController {


    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public String getAuthorsList(Model model) {

        Iterable<Author> all = authorRepository.findAll();
        model.addAttribute("authors", all);

        return "author/list";
    }
}
