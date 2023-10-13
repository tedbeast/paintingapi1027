package demo.repository;

import demo.entity.Painting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaintingRepository extends JpaRepository<Painting, Integer> {
//    @Query
    List<Painting> findByYearMade(int yearMade);
}
