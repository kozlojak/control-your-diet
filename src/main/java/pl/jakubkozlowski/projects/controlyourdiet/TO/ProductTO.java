package pl.jakubkozlowski.projects.controlyourdiet.TO;

import lombok.Data;

@Data
public class ProductTO {
    private long id;
    private String name;
    private String typeOfPreparation;
    private Integer weight;
    private Double carbs;
    private Double fat;
    private Double proteins;
    private Double cellulose;

}

