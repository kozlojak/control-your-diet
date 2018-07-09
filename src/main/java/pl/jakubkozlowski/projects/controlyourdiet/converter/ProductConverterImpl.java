package pl.jakubkozlowski.projects.controlyourdiet.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import pl.jakubkozlowski.projects.controlyourdiet.TO.ProductTO;
import pl.jakubkozlowski.projects.controlyourdiet.model.ProductEntity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverterImpl implements ProductConverter{
    private ModelMapper modelMapper;

    @Autowired
    public ProductConverterImpl(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    @Override
    public ProductTO convertEntity(ProductEntity productEntity) {
        if(productEntity==null){
            return null;
        }
        return modelMapper.map(productEntity, ProductTO.class);
    }

    @Override
    public ProductEntity convertTO(ProductTO productTO) {
        if(productTO==null){
            return null;
        }
        return modelMapper.map(productTO, ProductEntity.class);
    }

    @Override
    public List<ProductTO> convertListEntity(List<ProductEntity> listEntity) {
        if(CollectionUtils.isEmpty(listEntity)){
            return Collections.emptyList();
        }
        return listEntity.stream().map(this::convertEntity).collect(Collectors.toList());
    }
}
