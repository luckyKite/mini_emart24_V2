package com.example.emart24.controller;

import com.example.emart24.domain.Product;
import com.example.emart24.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
  private final ProductService productService;

  //전체 상품 조회
  @GetMapping("/all")
  public List<Product> getAll() {
    return productService.getAll();
  }

  //선택한 상품 상세보기
  @GetMapping("/{id}")
  public Product getProductDetail(@PathVariable Long id) {
    return productService.getProductDetail(id);
  }
  //단어로 상품 검색하기
  @GetMapping("/search")
  public List<Product> getSearchList(@RequestParam String q) {
    return productService.getSearchList(q);
  }
}
