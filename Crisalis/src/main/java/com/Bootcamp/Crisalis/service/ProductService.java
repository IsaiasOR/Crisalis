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

    public Product deleteProductById(Integer id) {
        if (this.productRepository.existsById(id)) {
            return this.productRepository.deleteProductById(id);
        }
        throw new NotEliminatedException("Error in deleting product");
    }

    public ProductDTO findProductById(Integer id) {
        return this.productRepository.findById(id)
                    .orElseThrow(
                            () -> new UnauthorizedException("Product doesn't exist")
                    ).toDTO();
    }

    public List<ProductDTO> getListAllProductsInBD() {
        return this.productRepository
                .findAll()
                .stream()
                .map(Product::toDTO)
                .collect(Collectors.toList());
    }

    public Product updateProduct(ProductDTO productDTO, Integer id) {
        if (this.productRepository.existsById(id)) {
            if (this.checkProductDTO(ProductDTO
                    .builder()
                    .name(productDTO.getName())
                    .build())) {
                this.productRepository.getReferenceById(id).setName(productDTO.getName());
            }
            if (this.checkProductDTO(ProductDTO
                    .builder()
                    .baseAmount(productDTO.getBaseAmount())
                    .build())) {
                this.productRepository.getReferenceById(id).setBaseAmount(productDTO.getBaseAmount());
            }
            if (this.checkProductDTO(ProductDTO
                    .builder()
                    .guarantee(productDTO.getGuarantee())
                    .build())) {
                this.productRepository.getReferenceById(id).setGuarantee(productDTO.getGuarantee());
            }
            return this.productRepository.getReferenceById(id);
        }
        throw new NotUpdateException("Product doesn't exist");
    }
}
