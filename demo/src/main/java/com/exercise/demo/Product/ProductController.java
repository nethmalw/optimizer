package com.exercise.demo.Product;

import com.exercise.demo.CategorizedUnits;
import com.exercise.demo.PriceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> allProducts = new ArrayList<>();

        for (Product element : productService.getAllProducts()) {
            ProductDTO push = new ProductDTO();

            push.setProductId(element.getProductId());
            push.setProductName(element.getProductName());
            push.setCartonPrice(element.getCartonPrice());
            push.setCartonSize(element.getCartonSize());
            push.setUnitPrice(PriceCalculator.getUnitPrice(element.getCartonPrice(), element.getCartonSize()));

            allProducts.add(push);
        }
        return allProducts;
    }

    @PostMapping("/priceCalculate")
    public Suggested getSuggestion(@RequestBody ReceiveBody received) {

        Product product = productService.getProductById(received.getProductId());
        CategorizedUnits categorized = PriceCalculator.getCartonsAndUnits(received.getNoOfCartons() * product.getCartonSize() + received.getNoOfUnits(), product.getCartonSize());
        double totalPrice = PriceCalculator.getTotalPrice(categorized, product.getCartonPrice(), product.getCartonSize());

        Suggested suggestion = new Suggested();
        suggestion.setProductId(received.getProductId());
        suggestion.setProductName(product.getProductName());
        suggestion.setNoOfCartons(categorized.getCartons());
        suggestion.setNoOfUnits(categorized.getUnits());
        suggestion.setTotalPrice(totalPrice);

        return suggestion;

    }


}

