package learning.springframework.spring5webapp.controllers;

// NOTE: To create a new controller:
//  1. Create a new class in the controllers package
//  2. Add the @Controller annotation to the class
//  3. Add repository to inject into the controller
//  4. Add the constructor to inject the repository
//  5. Add a method to handle the request
//  6. Add the @RequestMapping annotation with URL parameter to the method
//  7. Add the model as parameter to the method
//  8. Add the model attribute in the method using the repository
//  9. Return the view name as "location/filename" (filename being the html in templates folder)

import learning.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());

        return "authors/list";
    }
}
