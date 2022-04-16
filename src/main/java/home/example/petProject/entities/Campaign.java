package home.example.petProject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "campaign")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int employees;
    private String email;
    private float price;
    @OneToMany(mappedBy = "campaign")
    //cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ads> ads;

}