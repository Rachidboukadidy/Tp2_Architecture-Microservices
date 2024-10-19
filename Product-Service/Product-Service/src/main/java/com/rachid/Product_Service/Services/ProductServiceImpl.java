package com.rachid.Product_Service.Services;

import com.rachid.Product_Service.Dao.ProductRepository;
import com.rachid.Product_Service.Dto.ProductRequest;
import com.rachid.Product_Service.Dto.ProductResponse;
import com.rachid.Product_Service.Entity.Product;
import com.rachid.Product_Service.Feign.RecommendationClient;
import com.rachid.Product_Service.Feign.ReviewClient;
import com.rachid.Product_Service.Feign.microservice.RecommendationResponse;
import com.rachid.Product_Service.Feign.microservice.ReviewResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    private final RecommendationClient recommendationClient;
    private final ReviewClient reviewClient;
    @Autowired
    public ProductServiceImpl(ReviewClient reviewClient, RecommendationClient recommendationClient) {
        this.reviewClient = reviewClient;
        this.recommendationClient = recommendationClient;
    }

    // for add a product
    @Override
    public ProductResponse addProduct(ProductRequest productrequest) {
        Product product = new Product();
        product.setName(productrequest.getName());
        product.setWeight(productrequest.getWeight());
        productRepository.save(product);
        return new ProductResponse(product);
    }

    public ProductResponse getProduct(long id) {
        Optional<Product> prod = productRepository.findById(id);
        ProductResponse productResponse = new ProductResponse();
        if (prod.isPresent()) {
                Product product1 = prod.get();
         return new ProductResponse(product1);
        }else{
            //il faut regeler le  retoure d'erreur
            productResponse.setId(-1);
                }
        return productResponse;

        }


    public List<ProductResponse> getAllProducts() {
        List <Product> prod = productRepository.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : prod) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(product.getId());
            productResponse.setName(product.getName());
            productResponse.setWeight(product.getWeight());
            productResponses.add(productResponse);
        }
        return productResponses;
    }

    @Override
    public void updateProduct(long id, ProductRequest product) {
        Optional<Product> prod = productRepository.findById(id);
        if(prod.isPresent()) {
            Product product1 = prod.get();
            product1.setName(product1.getName());
            product1.setWeight(product1.getWeight());
            productRepository.save(product1);

        }
    }

    @Override
    public void deleteProduct(long id) {
        Optional<Product> prod = productRepository.findById(id);
        if (prod.isPresent()) {
            productRepository.delete(prod.get());
        }

    }
    public ProductResponse findProductById(Long id){
        Optional<Product> product = productRepository.findById(id);
        ProductResponse productRes = new ProductResponse();
        if(product.isPresent()){
            Product product1 = product.get();
            productRes.setId(product1.getId());
            productRes.setName(product1.getName());
            productRes.setWeight(product1.getWeight());
            RecommendationResponse recommendation = recommendationClient.getRecommendationByProductId(id);
            productRes.setRecommendationRes(recommendation);
            ReviewResponse reviewRes= reviewClient.getReviewsByProductId(id);
            productRes.setReviewRes(reviewRes);
        }
        return productRes;
    }



}
