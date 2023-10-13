package demo.service;

import demo.entity.Author;
import demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
//@Service
public class AuthorService {
    AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }
}
