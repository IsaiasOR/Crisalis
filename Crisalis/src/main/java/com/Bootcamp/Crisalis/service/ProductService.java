package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.enums.Status;
import com.Bootcamp.Crisalis.exception.custom.*;
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
            productDTO.setStatus(Status.INACTIVE);
            return this.productRepository.save(new Product(productDTO));
        }
        throw new NotCreatedException("Error in save new product");
    }

//    public BigDecimal calculatedTotalAmount(ProductDTO productDTO) {
//        BigDecimal total = new BigDecimal(0);
//
//        total = total.add(productDTO.getBaseAmount());
//
//        if (!ObjectUtils.isEmpty(productDTO.getTaxes())) {
//            List<BigDecimal> taxes =
//                    productDTO
//                            .getTaxes()
//                            .stream()
//                            .map(Tax::getPercentage)
//                            .collect(Collectors.toList());
//
//            for ( BigDecimal t : taxes) {
//                total = total.add(total
//                        .multiply(t)
//                        .divide(new BigDecimal(100)));
//            }
//        }
//
//        if (productDTO.getGuarantee() > 0) {
//            BigDecimal guarantee = productDTO.getBaseAmount()
//                    .multiply(new BigDecimal(2))
//                    .divide(new BigDecimal(100));
//
//            int i = productDTO.getGuarantee();
//            while(i > 0) {
//                total = total.add(guarantee);
//                i--;
//            }
//        }
//
//        return total;
//    }

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
            if (!ObjectUtils.isEmpty(productDTO.getGuarantee())) {
                newProduct.setGuarantee(productDTO.getGuarantee());
            }
            if (!ObjectUtils.isEmpty(productDTO.getTaxes())) {
                newProduct.setTaxes(productDTO.getTaxes());
            }
            if (!ObjectUtils.isEmpty(productDTO.getStatus())) {
                newProduct.setStatus(productDTO.getStatus());
            }
            return this.productRepository.save(newProduct);
        }
        throw new NotUpdateException("Product doesn't exist");
    }
}
