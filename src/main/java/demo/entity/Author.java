package demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

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
    private int authorId;
    private String name;
}
