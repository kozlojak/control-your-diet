package pl.jakubkozlowski.projects.controlyourdiet.converter;

import pl.jakubkozlowski.projects.controlyourdiet.TO.ProductTO;
import pl.jakubkozlowski.projects.controlyourdiet.model.ProductEntity;

import java.util.List;

public interface ProductConverter{

    ProductTO convertEntity(ProductEntity entity);
    ProductEntity convertTO(ProductTO tO);
    List<ProductTO>convertListEntity(List<ProductEntity> entityList);

}
