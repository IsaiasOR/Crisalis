package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.exception.custom.EmptyElementException;
import com.Bootcamp.Crisalis.exception.custom.NotCreatedException;
import com.Bootcamp.Crisalis.exception.custom.NotEliminatedException;
import com.Bootcamp.Crisalis.exception.custom.UnauthorizedException;
import com.Bootcamp.Crisalis.model.Need;
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
            throw new EmptyElementException("Name is empty");
        }
        if (ObjectUtils.isEmpty(productDTO.getBaseAmount())) {
            throw new EmptyElementException("Base amount is empty");
        }
        if (ObjectUtils.isEmpty(productDTO.getGuarantee())) {
            throw new EmptyElementException("Guarantee is empty");
        }
        if (ObjectUtils.isEmpty(productDTO.getNeed())) {
            throw new EmptyElementException("Need is empty");
        }
        return Boolean.TRUE;
    }

    public Product deleteProductByNeed(Need need) {
        if (checkProductDTO(ProductDTO
                .builder()
                .need(need)
                .build())) {
            return this.productRepository.deleteByNeed(need);
        }
        throw new NotEliminatedException("Error in deleting product");
    }

    public void deleteProductById(Integer id) {
        this.productRepository.deleteById(id);
    }

    public ProductDTO findProductByNeed(Need need) {
        if (checkProductDTO(ProductDTO
                .builder()
                .need(need)
                .build())) {
            return this.productRepository.findByNeed(need)
                    .orElseThrow(
                            () -> new UnauthorizedException("Product doesn't exist")
                    ).toDTO();
        }
        throw new UnauthorizedException("Invalid credentials");
    }

    public List<ProductDTO> getListAllProductsInBD() {
        return this.productRepository
                .findAll()
                .stream()
                .map(Product::toDTO)
                .collect(Collectors.toList());
    }
}