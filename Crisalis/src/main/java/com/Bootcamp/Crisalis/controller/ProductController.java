package com.Bootcamp.Crisalis.controller;

import com.Bootcamp.Crisalis.model.Product;
import com.Bootcamp.Crisalis.model.dto.ProductDTO;
import com.Bootcamp.Crisalis.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = {"localhost:8080", "localhost", "http://localhost:4200"})
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/new",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Product saveProduct(@RequestBody ProductDTO productDTO) {
        return this.productService.saveProduct(productDTO);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public Product deleteProductById(@PathVariable("id") Integer id) {
        return this.productService.deleteProductById(id);
    }

    @GetMapping(value = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDTO> getListAllProductsInBD() {
        return this.productService.getListAllProductsInBD();
    }

    @GetMapping(value = "/findProduct/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO findProductByNeed(@PathVariable("id") Integer id) {
        return this.productService.findProductById(id);
    }

    @PutMapping(value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct(@RequestBody ProductDTO productDTO, @PathVariable("id") Integer id) {
        return this.productService.updateProduct(productDTO, id);
    }
}
