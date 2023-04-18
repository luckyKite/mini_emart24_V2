package com.example.emart24.service;

import com.example.emart24.domain.Product;
import com.example.emart24.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;

  @Transactional
  public List<Product> getAll() {
    return productRepository.getAll();
  }

  public Product getProductDetail(Long id) {
    return productRepository.findId(id);
  }

  public List<Product> getSearchList(String q) {
    return productRepository.getSearchList(q);
  }

  //관리자 - 상품 등록하기
  @Transactional
  public void saveProduct(Product product) {
    productRepository.save(product);
  }

  //관리자 - 상품 수정하기
  @Transactional
  public void updateItem(Long productId, int price, double discount, double rating) {
    Product product = productRepository.findId(productId);
    product.setPrice(price);
    product.setDiscount(discount);
    product.setRating(rating);
  }

  public Product findId(Long id) {
    return productRepository.findId(id);
  }

  @Transactional
  public void deleteProduct(Long id) {
    productRepository.deleteProduct(id);
  }
}
