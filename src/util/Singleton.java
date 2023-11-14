package util;

import controller.MenuController;
import controller.ProductController;
import server.ProductServiceimpl;

import java.util.Scanner;

public class Singleton {
    private static Scanner scanner;
    private static ProductController productController;
   private static ProductServiceimpl productServiceimpl;
   private static MenuController menuController;

   public static Scanner Scanner(){
       if(scanner==null){
           scanner = new Scanner(System.in);
       }
       return scanner;
   }

   public static ProductController productController(){
       if(productController==null){
           productController = new ProductController();
       }
       return productController;
   }

   public static ProductController getProductServiceimpl(){
       if(productServiceimpl==null){
           productServiceimpl= new ProductServiceimpl();
       }
       return productController;
   }

   public static MenuController menuController(){
       if(menuController==null){
           menuController= new MenuController();
       }
       return menuController;
   }


}
