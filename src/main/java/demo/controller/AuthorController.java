package demo.controller;

import demo.entity.Author;
import demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Stereotype annotation built on top of @Controller, itself built on top of @Component
//RestContoller will assume that we want to respond with JSON response bodies

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class AuthorController {
    AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }
    @GetMapping("/author")
    public List<Author> getAllAuthor(){
        return authorService.getAllAuthor();
    }
//    later on, I'd like to use something called a 'response entity' to configure the response
    @PostMapping("/author")
    public Author postAuthor(@RequestBody Author author){
        return authorService.saveAuthor(author);
    }
}
