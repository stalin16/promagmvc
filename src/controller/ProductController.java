package controller;

import dto.CreateProductDto;
import dto.UpdateProductDto;
import model.Product;
import server.ProductService;
import server.ProductServiceimpl;
import util.Singleton;
import view.ProductView;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    Scanner scanner;
    private ProductService productService;
    public ProductController(){
        productService = new ProductServiceimpl();
        scanner = Singleton.Scanner();
    }
    public void index(){
        List<Product> products = productService.select();
        ProductView.printProductList(products);
    }
    public void createProduct(CreateProductDto createProductDto) {
        Product createProduct = new Product(createProductDto.getId(), createProductDto.getName(), createProductDto.getQty(), createProductDto.getPrice(), LocalDate.now());
        productService.insert(createProduct);
    }

    public Product updateProduct(String id, UpdateProductDto updateProductDto) {
        return productService.updateById(id, updateProductDto);
    }

    public void deleteById(Long id) {
        productService.deleteById(id);
    }
}
