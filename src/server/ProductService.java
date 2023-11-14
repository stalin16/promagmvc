package server;

import dto.UpdateProductDto;
import model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product insert(Product product);

    List<Product> select();

    Optional<Product> selectById(Long id);

    Optional<Product> updateById(Product product);

    Product deleteById(Long id);

    List<Product> selectByName(String name);

    Product updateById(String id, UpdateProductDto updateProductDto);
}
