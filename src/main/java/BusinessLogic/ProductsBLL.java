package BusinessLogic;

import DataAccess.ProductsDAO;
import Model.Products;

import java.util.List;

/**
 * Class for the business logic of the Products class.
 * It is used to call the methods that were implemented in the AbstractDAO class that were extended in the ProductsDAO class
 * @author maria
 * @since June 2024
 */
public class ProductsBLL {
    public static List<Products> findAllProducts() {
        ProductsDAO productDAO = new ProductsDAO();
        return productDAO.findAll();
    }

    public static Products findProductById(int id) {
        ProductsDAO productDAO = new ProductsDAO();
        return productDAO.findById(id, "productId");
    }

    public static void insertProduct(Products product) {
        ProductsDAO productDAO = new ProductsDAO();
        productDAO.insert(product);
    }

    public static void editProduct (Products product) {
        ProductsDAO productDAO = new ProductsDAO();
        productDAO.update(product, "productId");
    }

    public static void deleteOrder (int idToBeDeleted) {
        ProductsDAO productDAO = new ProductsDAO();
        productDAO.delete(idToBeDeleted, "productId");
    }

}
