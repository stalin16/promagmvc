import controller.MenuController;
import controller.ProductController;
import dto.CreateProductDto;
import dto.UpdateProductDto;
import util.Singleton;

import java.util.Scanner;

public class Main {

//    private static ProductService productService;
//
//    public Main(){
//        productService = new ProductServiceimpl();
//    }
    private final Scanner scanner;
    private final MenuController menuController;
    private final ProductController productController;

    public Main(){
        scanner = Singleton.Scanner();
        menuController = Singleton.menuController();
        productController = Singleton.productController();


    }
    private void createProduct() {
        System.out.println("Create Product");
        System.out.print("Input Product ID: ");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.print("Input Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Input Product Qty: ");
        Integer qty = Integer.parseInt(scanner.nextLine());
        System.out.print("Input Product Price: ");
        Double price = Double.parseDouble(scanner.nextLine());
        CreateProductDto createProductDto = new CreateProductDto(id, name, qty, price);
        productController.createProduct(createProductDto);
        System.out.println("Product has added");
    }

    private void deleteProduct() {
        System.out.print("Input Product ID to delete: ");
        Long fId = Long.parseLong(scanner.nextLine());
        productController.deleteById(fId);
        System.out.println("Product ID is deleted: " + fId);
    }

    private void updateProduct( ) {
        System.out.println("Update the Product");
        System.out.print("Input ID to update product: ");
        String id = scanner.nextLine();
        System.out.print("Input Product Name: ");
        String newName = scanner.nextLine();
        System.out.print("Input Product Qty: ");
        Integer newQty = Integer.parseInt(scanner.nextLine());
        System.out.print("Input Product Price: ");
        Double newPrice = Double.parseDouble(scanner.nextLine());
        UpdateProductDto updateProductDto = new UpdateProductDto(newName, newQty, newPrice);
        productController.updateProduct(id, updateProductDto);
        System.out.println("Product has updated");
    }
    private void run(){
        menuController.index();
        System.out.println("Enter Option: ");
        int op = Integer.parseInt(scanner.nextLine());

        switch (op){
            case 1-> productController.index();
            case 2-> createProduct();
            case 3-> deleteProduct();
            case 4-> updateProduct();
            default -> throw new IllegalStateException();
        }
    }


    public static void main(String[] args) {
        while (true){
            new  Main().run();
        }

//        scanner2 = Singleton.Scanner();
//        scanner3 = Singleton.Scanner();
//        System.out.println(scanner.hashCode());
//        System.out.println(scanner2.hashCode());
//        System.out.println(scanner3.hashCode());
//        Scanner scanner = new Scanner(System.in);
//        ProductController productController = new ProductController();
//        MenuController menuController = new MenuController();

//        Scanner scanner = new Scanner(System.in);
//        productService = new ProductServiceimpl();
//
//        System.out.println("Welcome to PMS");
//        MenuView.menu();
//
//        int option = Integer.parseInt(scanner.nextLine());
//
//        switch(option){
//            case 1-> {
//                List<Product> products = productService.select();
//                ProductView.printProductList(products);
//            }
//            default -> throw new IllegalArgumentException();
//
//        }



    }
}