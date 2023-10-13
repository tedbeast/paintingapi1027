package demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

//Entity is provided by javax persistence (framework for ORM tools)
@Entity
//Lombok (not spring)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Author {
//    defines the primary key, and is required for ORM entity
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;
    private String name;

    @OneToMany(mappedBy="author")
    List<Painting> paintings;
}
