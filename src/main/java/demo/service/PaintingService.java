package demo.service;

import demo.entity.Author;
import demo.entity.Painting;
import demo.repository.AuthorRepository;
import demo.repository.PaintingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
public class PaintingService {
    PaintingRepository paintingRepository;
    AuthorRepository authorRepository;
    @Autowired
    public PaintingService(PaintingRepository paintingRepository, AuthorRepository authorRepository){
        this.paintingRepository = paintingRepository;
        this.authorRepository = authorRepository;
    }

    public Painting savePaintingToAuthor(Painting painting, int id) {
        Painting p =paintingRepository.save(painting);
        Author a = authorRepository.findById(id).get();
        p.setAuthor(a);
        p = paintingRepository.save(p);
        return p;
    }
    public List<Painting> getAllPaintings(){
        return paintingRepository.findAll();
    }

    public List<Painting> getAllPaintingsByYear(int yearMade) {
        return paintingRepository.findByYearMade(yearMade);
    }
}
