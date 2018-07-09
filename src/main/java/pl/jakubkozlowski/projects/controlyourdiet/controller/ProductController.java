package pl.jakubkozlowski.projects.controlyourdiet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jakubkozlowski.projects.controlyourdiet.TO.ProductTO;
import pl.jakubkozlowski.projects.controlyourdiet.controller.descriptor.ProductDescriptor;
import pl.jakubkozlowski.projects.controlyourdiet.service.ProductService;

import java.util.List;

import static pl.jakubkozlowski.projects.controlyourdiet.controller.descriptor.ProductDescriptor.ALL;
import static pl.jakubkozlowski.projects.controlyourdiet.controller.descriptor.ProductDescriptor.BY_ID;

@RestController
@RequestMapping(path = ProductDescriptor.PRODUCT_BASE_PATH)
public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service= service;
    }

    @PostMapping
    public ResponseEntity<ProductTO> save(@RequestParam("product") ProductTO product) {
        service.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping(value=BY_ID)
    public ResponseEntity<ProductTO> findById(@PathVariable("id") Long id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<ProductTO>>findByName(@RequestParam("name") String name){
        return service.findByName(name).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping(value=ALL)
    public ResponseEntity<List<ProductTO>>findAll(){
        return service.findAll().map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping(value=BY_ID)
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value=BY_ID)
    public ResponseEntity<ProductTO> update(@PathVariable("id") Long id, @RequestBody ProductTO productTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, productTO));
    }

}
