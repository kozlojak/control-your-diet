package pl.jakubkozlowski.projects.controlyourdiet.service;

import pl.jakubkozlowski.projects.controlyourdiet.TO.ProductTO;

import java.util.Optional;

public interface CRUDService<TO> {
    TO save(TO objectTO);

    Optional<TO> findById(Long id);

    ProductTO update(Long id, TO objectTO);

    void deleteById(Long id);


}
