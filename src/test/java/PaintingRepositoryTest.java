import demo.Application;
import demo.entity.Painting;
import demo.repository.PaintingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = Application.class)
public class PaintingRepositoryTest {
    @Autowired
    PaintingRepository paintingRepository;

    /**
     * Test the findByYearMade query by adding two paintings of different years, retrieving all
     * paintings from one year, and verifying it only contains the painting of the correct year.
     */
    /**
    @Test
    public void findByYearMadeTest(){
        Painting p1 = new Painting(1, "p1", "p1.jpg", 2023, null);
        Painting p2 = new Painting(2, "p2", "p2.jpg", 2022, null);
        paintingRepository.save(p1);
        paintingRepository.save(p2);

        List<Painting> actual = paintingRepository.findByYearMade(2023);
        Assertions.assertTrue(actual.size() == 1);
        Assertions.assertTrue(actual.get(0).getPaintingId() == 1);
    }**/
}
