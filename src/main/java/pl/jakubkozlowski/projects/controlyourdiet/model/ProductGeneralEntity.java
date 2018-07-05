package pl.jakubkozlowski.projects.controlyourdiet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_general")
@Data
@AllArgsConstructor
@ToString
public class ProductGeneralEntity implements Serializable {

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

    public ProductGeneralEntity(String name, String typeOfPreparation, Integer weight, Float carbs, Float fat,
                                Float proteins, Float cellulose){
        this.name=name;
        this.typeOfPreparation=typeOfPreparation;
        this.weight=weight;
        this.carbs=carbs;
        this.fat=fat;
        this.proteins=proteins;
        this.cellulose=cellulose;
    }
}
