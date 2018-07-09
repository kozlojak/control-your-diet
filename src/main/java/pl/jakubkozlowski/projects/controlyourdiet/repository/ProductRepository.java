package pl.jakubkozlowski.projects.controlyourdiet.repository;

import org.springframework.data.repository.CrudRepository;
import pl.jakubkozlowski.projects.controlyourdiet.model.ProductEntity;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    List<ProductEntity> findByName(String name);
    List<ProductEntity> findAll();
}