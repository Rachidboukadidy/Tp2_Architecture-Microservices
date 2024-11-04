package com.rachid.Product_Service.Controllers;

import com.rachid.Product_Service.Dto.ProductRequest;
import com.rachid.Product_Service.Dto.ProductResponse;

import com.rachid.Product_Service.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private  ProductService productService ;



    @PostMapping
    public ProductResponse addProduct( @RequestBody ProductRequest productRequest) {
        return productService.addProduct(productRequest);
    }
    //for get all the products
    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    // for get one product
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct( @PathVariable long id) {
        ProductResponse productResponse = productService.getProduct(id);
//        // Simule une erreur si l'ID du produit est pair
//        if (id % 2 == 0) {
//            throw new RuntimeException("Erreur simulée pour le produit " + id);
//        }
        return ResponseEntity.ok().body(productResponse);
    }
    // for delete a product
    @DeleteMapping("/{id}")
    public void deleteProduct( @PathVariable long id) {
        productService.deleteProduct(id);
    }
    // for update a product
    @PutMapping("/{id}")
    public void updateProduct( @PathVariable long id, ProductRequest productRequest) {
        productService.updateProduct(id, productRequest);
    }


}
