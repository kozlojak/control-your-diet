package pl.jakubkozlowski.projects.controlyourdiet.service;

import pl.jakubkozlowski.projects.controlyourdiet.TO.ProductTO;

import java.util.List;
import java.util.Optional;

public interface ProductService extends CRUDService<ProductTO>  {
    Optional<List<ProductTO>> findAll();
    Optional<List<ProductTO>> findByName(String name);
}
