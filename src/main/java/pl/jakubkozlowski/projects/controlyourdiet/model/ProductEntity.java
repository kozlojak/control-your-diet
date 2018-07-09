package pl.jakubkozlowski.projects.controlyourdiet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "product_general")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private String typeOfPreparation;

    @Column
    private Integer weight;

    @Column
    private Float carbs;

    @Column
    private Float fat;

    @Column
    private Float proteins;

    @Column
    private Float cellulose;
}
