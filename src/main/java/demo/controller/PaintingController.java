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
    public Painting postPaintingToAuthor(@RequestBody Painting painting, @PathVariable("id") int id, @RequestHeader("current-user") String username){
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
/**
 * recommendation: pass the current user in the header for every sensitive request from the frontend,
 * verify that the user exists/is allowed to perform the action ( eg only admins can resolve tickets)
 * from the backend by querying the database.
 *
 * in the real world, we'd just use a JWT instead of the username, obviously, but you might be able to
 * even find a poorly made professional site that is insecure in this way (just a hunch)
 *
 * OWASP top 10 - organization that studies and published information on security topics in web development
 *
 * SDLC - "what is the most important/critical step?"
 * Analysis (business analysts / managers : gathering requirements - what exactly is the app supposed to do? write out our user stories)
 * Design (senior / principal developers : what technologies are we using and how do we build it?)
 * Implementation (developers : writing the app)
 * Testing (developers / testers : performing different types of tests) : can we prove the code works correctly?
 *      - unit tests (testing an individual atomic piece of code, typically a single method)
 *      - integration tests (testing that multiple parts of the app can integrate together)
 *      - BDD tests (testing that the application works based off of its end behavior, for either
 *          frontend (selenium) or backend (karate)
 *      - end-to-end tests (testing the entire application)
 *      specialized testing, eg,
 *      - penetration testing for testing security measures
 *      - stress / performance testing, simulating high activity
 * Maintenance (SRE / developers) : verifying that everything works, recovering from failures, noting any issues
 *      - support tiers, L1/L2/L3 (application developers / support developers / non-technical support staff)
 */