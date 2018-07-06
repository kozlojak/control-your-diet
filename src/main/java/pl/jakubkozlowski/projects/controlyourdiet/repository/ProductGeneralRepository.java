package pl.jakubkozlowski.projects.controlyourdiet.repository;

import org.springframework.data.repository.CrudRepository;
import pl.jakubkozlowski.projects.controlyourdiet.model.ProductGeneralEntity;

import java.util.List;

public interface ProductGeneralRepository extends CrudRepository<ProductGeneralEntity, Long> {
    List<ProductGeneralEntity> findByName(String name);
}
