package pl.jakubkozlowski.projects.controlyourdiet.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductGeneralEntity {
    private String name;
    private String typeOfPreparation;
    private Integer weight;
    private Float carbs;
    private Float fat;
    private Float proteins;
    private Float cellulose;

}
