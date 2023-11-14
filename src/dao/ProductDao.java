package dao;

import model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {


    // crud = create read update delete
    Product insert(Product product);

    List<Product> select();

    Optional<Product> selectById(Long id);

    Optional<Product> updateById(Product product);

    Product deleteById(Long id);

    List<Product> selectByName(String name);


}
