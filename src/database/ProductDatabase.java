package database;

import model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private ProductDatabase productDb;
    public void ProductDaiImpl(){
        productDb = new ProductDatabase();
    }
    private List<Product> products;
    public ProductDatabase(){
        products = new ArrayList<>();
        products.add(new Product(1L, "Coca",100, 2500.0, LocalDate.now()));
        products.add(new Product(2L, "Pepsi",10, 2400.0, LocalDate.now()));
        products.add(new Product(3L, "Sandwich",50, 2300.0, LocalDate.now()));
        products.add(new Product(4L, "Coke",200, 2200.0, LocalDate.now()));
        products.add(new Product(5L, "Fanta",300, 2000.0, LocalDate.now()));


    }
    public  List<Product> getProducts(){
        return products;
    }
}
