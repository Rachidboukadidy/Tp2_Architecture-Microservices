package com.rachid.Product_Service.Services;

import com.rachid.Product_Service.Dto.ProductRequest;
import com.rachid.Product_Service.Dto.ProductResponse;

import java.util.List;


public interface ProductService {
    public ProductResponse addProduct(ProductRequest product);
    public ProductResponse getProduct(long id);
    public List<ProductResponse> getAllProducts();
    public void updateProduct(long id, ProductRequest product);
    public void deleteProduct(long id);
}
