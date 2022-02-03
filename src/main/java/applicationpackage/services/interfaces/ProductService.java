package applicationpackage.services.interfaces;

import applicationpackage.data.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    void addProduct(Product product);

}
