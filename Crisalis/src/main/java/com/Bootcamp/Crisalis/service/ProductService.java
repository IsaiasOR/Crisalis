package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.exception.custom.*;
import com.Bootcamp.Crisalis.model.Product;
import com.Bootcamp.Crisalis.model.dto.ProductDTO;
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
        if (!this.productRepository.existsById(id)) {
            throw new NotEliminatedException("Error in deleting product");
        }
        this.productRepository.deleteById(id);
    }

    public Product findProductById(Integer id) {
        return this.productRepository.findById(id)
                    .orElseThrow(
                            () -> new UnauthorizedException("Product doesn't exist")
                    );
    }

    public List<ProductDTO> getListAllProductsInBD() {
        return this.productRepository
                .findAll()
                .stream()
                .map(Product::toDTO)
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
            if (!ObjectUtils.isEmpty(productDTO.getGuarantee())) {
                newProduct.setGuarantee(productDTO.getGuarantee());
            }
            return this.productRepository.save(newProduct);
        }
        throw new NotUpdateException("Product doesn't exist");
    }
}
