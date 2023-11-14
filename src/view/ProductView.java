package view;

import model.Product;
import java.util.List;
import static java.lang.System.*;

public class ProductView {
    public static void printProductList(List<Product> products){
        out.println("Product List");
        products.forEach(product -> {
            out.println("ID "+product.getId());
            out.println("Name "+product.getName());
            out.println("Qty "+product.getQty());
            out.println("Price "+product.getPrice());
            out.println("Imported Date "+product.getImportedDate());
        });
    }
}
