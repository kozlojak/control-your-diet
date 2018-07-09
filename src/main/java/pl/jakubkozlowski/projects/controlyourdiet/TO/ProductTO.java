package pl.jakubkozlowski.projects.controlyourdiet.TO;

import lombok.Data;

@Data
public class ProductTO {
    private long id;
    private String name;
    private String typeOfPreparation;
    private Integer weight;
    private Float carbs;
    private Float fat;
    private Float proteins;
    private Float cellulose;

}

