package home.example.petProject.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
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
    private List<Ads> ads;

    public Campaign(){}

    public Campaign(Long id, String name, int employees, String email, float price) {
        this.id = id;
        this.name = name;
        this.employees = employees;
        this.email = email;
        this.price = price;
    }
}