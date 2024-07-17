package br.com.ecommerce.service;

import br.com.ecommerce.controller.product.request.ProductPurchaseRequest;
import br.com.ecommerce.model.Product;
import br.com.ecommerce.service.vo.ProductPurchaseVO;

import java.util.List;

public interface ProductService {

    Integer createProduct(Product product);

    List<Product> purchaseProduct(List<Product> productList);

    Product findProductById(Integer id);

    List<Product> allProducts();

    List<ProductPurchaseVO> listProductPurchase(List<ProductPurchaseVO> productPurchase);
}
