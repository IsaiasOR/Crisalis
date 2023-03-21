package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.exception.custom.*;
import com.Bootcamp.Crisalis.model.Order;
import com.Bootcamp.Crisalis.model.Product;
import com.Bootcamp.Crisalis.model.dto.ProductDTO;
import com.Bootcamp.Crisalis.model.dto.ProductItemDTO;
import com.Bootcamp.Crisalis.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product saveProduct(ProductDTO productDTO) {
        if (checkProductDTO(productDTO)) {
            return this.productRepository.save(new Product(productDTO));
        }
        throw new NotCreatedException("Error in save new product");
    }

    private Boolean checkProductDTO(ProductDTO productDTO) {
        if (StringUtils.isEmpty(productDTO.getName())) {
            throw new EmptyElementException("Name product is empty");
        }
        if (ObjectUtils.isEmpty(productDTO.getBaseAmount())) {
            throw new EmptyElementException("Base amount is empty");
        }
        return Boolean.TRUE;
    }

    public void deleteProductById(Integer id) {
        if (this.productRepository.existsById(id)) {
            this.productRepository.deleteById(id);
        }
        throw new NotEliminatedException("Error in deleting product");
    }

    public ProductDTO findProductById(Integer id) {
        if (this.productRepository.existsById(id)) {
            return this.productRepository.findById(id).get().toDTO();
        }
        throw new UnauthorizedException(("Product doesn't exist"));
    }

    public List<ProductItemDTO> getListAllProductsInBD() {
        return this.productRepository
                .findAll()
                .stream()
                .map(Product::toItemDTO)
                .collect(Collectors.toList());
    }

    public Product updateProduct(ProductDTO productDTO, Integer id) {
        Product newProduct = productRepository.getReferenceById(id);

        if (this.productRepository.existsById(id)) {
            if (!StringUtils.isEmpty(productDTO.getName())) {
                newProduct.setName(productDTO.getName());
            }
            if (!ObjectUtils.isEmpty(productDTO.getBaseAmount())) {
                newProduct.setBaseAmount(productDTO.getBaseAmount());
            }
            return this.productRepository.save(newProduct);
        }
        throw new NotUpdateException("Product doesn't exist");
    }

    public List<Product> getAllProductsCompleteInBD() {
        return this.productRepository.findAll();
    }
}
