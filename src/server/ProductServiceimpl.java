package server;

import dao.ProductDao;
import dao.ProductDaoImpl;
import dto.UpdateProductDto;
import exception.ProductIdNotFoundException;
import model.Product;

import java.util.List;
import java.util.Optional;

public class ProductServiceimpl implements ProductService {

    private final ProductDao productDao;
    public ProductServiceimpl(){
        productDao = new ProductDaoImpl();
    }


    @Override
    public Product insert(Product product) {
        return productDao.insert(product );
    }

    @Override
    public List<Product> select() {
        return productDao.select();
    }

    @Override
    public Optional<Product> selectById(Long id) {
        return Optional.ofNullable(productDao.selectById(id)
                .orElseThrow(()
                        -> new ProductIdNotFoundException(
                        String.format("Product ID= %s doesnt exist in DB!" + id)
                )));
    }

    @Override
    public Optional<Product> updateById(Product product) {
        return productDao.updateById(product);
    }

    @Override
    public Product deleteById(Long id) {
        return productDao.deleteById(id);
    }

    @Override
    public List<Product> selectByName(String name) {
        return productDao.selectByName(name);
    }

    @Override
    public Product updateById(String id, UpdateProductDto updateProductDto) {
        return null;
    }
}
