package dao;

import database.ProductDatabase;
import exception.ProductIdNotFoundException;
import model.Product;

import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {
    private final ProductDatabase productdb;
    public ProductDaoImpl(){
        productdb = new ProductDatabase();
    }
    @Override
    public Product insert(Product product) {

        productdb.getProducts().add(product);
        return product;
    }
    public List<Product> select(){
        return productdb.getProducts();
    }


//    @Override
//    public List<Product> select() {
//        return productDb.getProducts();
//    }


      @Override
    public Optional<Product> selectById(Long id) {
        return productdb.getProducts().stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Product> updateById(Product product) {
        return Optional.ofNullable(productdb.getProducts().stream()
                .filter(pro -> pro.getId().equals(product.getId()))
                .map(newPro -> product)
                .findFirst()
                .orElseThrow(()
                        -> new ProductIdNotFoundException(
                        String.format("Product ID= %s doesnt exist in DB!", product.getId())
                )));

    }

    @Override
    public Product deleteById(Long id) {
        return productdb.getProducts().stream()
                .filter(pro -> pro.getId().equals(id))
                .findFirst()
                .orElseThrow(()
                    -> new ProductIdNotFoundException(
                    String.format("Product ID= %s doesnt exist in DB!", id)
        ));
    }

    @Override
    public List<Product> selectByName(String name) {
        return productdb.getProducts().stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
