package demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Painting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int paintingId;
    public String title;
    public String imageUrl;
    public int yearMade;
    @ManyToOne
    @JsonIgnore
    Author author;
}
