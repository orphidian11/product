package net.orphidian11.projects.cars.product.mapper;

import net.orphidian11.projects.cars.product.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ProductMapper {

    public List<Product> findAll();

    public Product findById (@Param("id") Integer id);

    public Integer add(@Param("name") String name, @Param("description") String description, @Param("createdById") Integer createdById, @Param("createdByDate") Date createdByDate);

    public void edit(@Param("product") Product product);

    public void delete(@Param("product") Product product);

}
