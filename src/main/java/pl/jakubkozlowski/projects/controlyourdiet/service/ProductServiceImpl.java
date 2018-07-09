package pl.jakubkozlowski.projects.controlyourdiet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jakubkozlowski.projects.controlyourdiet.TO.ProductTO;
import pl.jakubkozlowski.projects.controlyourdiet.converter.ProductConverter;
import pl.jakubkozlowski.projects.controlyourdiet.model.ProductEntity;
import pl.jakubkozlowski.projects.controlyourdiet.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    private ProductConverter productConverter;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductConverter productConverter){
        this.productRepository=productRepository;
        this.productConverter=productConverter;
    }

    @Override
    public Optional<List<ProductTO>> findAll() {
        return Optional.ofNullable(productConverter.convertListEntity(productRepository.findAll()));
    }

    @Override
    public Optional<List<ProductTO>> findByName(String name) {
        return Optional.ofNullable(productConverter.convertListEntity(productRepository.findByName(name)));
    }

    @Override
    public ProductTO save(ProductTO productTO) {
        ProductEntity productEntity=productConverter.convertTO(productTO);
        productRepository.save(productEntity);
        return productConverter.convertEntity(productEntity);
    }

    @Override
    public Optional<ProductTO> findById(Long id) {
        return Optional.ofNullable(productConverter.convertEntity(productRepository.findById(id).get()));
    }

    @Override
    public ProductTO update(Long id, ProductTO productTO) {
        ProductTO productToUpdate=findById(id).get();
        productToUpdate.setId(productTO.getId());
        productToUpdate.setName(productTO.getName());
        productToUpdate.setTypeOfPreparation(productTO.getTypeOfPreparation());
        productToUpdate.setWeight(productTO.getWeight());
        productToUpdate.setCarbs(productTO.getCarbs());
        productToUpdate.setFat(productTO.getFat());
        productToUpdate.setProteins(productTO.getProteins());
        productToUpdate.setCellulose(productTO.getCellulose());
        ProductEntity productToUpdateEntity=productConverter.convertTO(productTO);
        productRepository.save(productToUpdateEntity);
        return productConverter.convertEntity(productToUpdateEntity);

    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


}
