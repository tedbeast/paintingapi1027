package demo.controller;

import demo.entity.Painting;
import demo.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class PaintingController {
    PaintingService paintingService;
    @Autowired
    public PaintingController (PaintingService paintingService){
        this.paintingService = paintingService;
    }
    @PostMapping("/author/{id}/painting")
    public Painting postPaintingToAuthor(@RequestBody Painting painting, @PathVariable("id") int id){
        return paintingService.savePaintingToAuthor(painting, id);
    }
    @GetMapping("/painting")
    public List<Painting> getAllPaintings(){
        return paintingService.getAllPaintings();
    }
    @GetMapping(value = "/painting", params = "yearMade")
    public List<Painting> getAllPaintingsByYearMade(@RequestParam int yearMade){
        if(yearMade == 0) {
            return paintingService.getAllPaintings();
        }else{
            return paintingService.getAllPaintingsByYear(yearMade);
        }
    }
}
