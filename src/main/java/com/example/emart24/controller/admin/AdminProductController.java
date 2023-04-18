package com.example.emart24.controller.admin;

import com.example.emart24.domain.Product;
import com.example.emart24.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminProductController {
  private final ProductService productService;

  @GetMapping("/items/new")
  public String createForm(Model model) {
    model.addAttribute("form", new ProductForm());
    return "items/createItemForm";
  }

  //상품등록 폼에 저장
  @PostMapping("/items/new")
  public String createForm(ProductForm form) {
    Product product = new Product();

    product.setPrice(form.getPrice());
    product.setDiscount(form.getDiscount());
    product.setRating(form.getRating());
    product.setName(form.getName());
    product.setThumbnail(form.getThumbnail());
    product.setDescription(form.getDescription());
    product.setCategory(form.getCategory());
    product.setBrand(form.getBrand());

    productService.saveProduct(product);
    return "redirect:/items";
  }

  //상품목록 확인하기
  @GetMapping("/items")
  public String list(Model model) {
    List<Product> allProducts = productService.getAll();
    model.addAttribute("allProducts", allProducts);
    return "items/itemList";
  }

  //상품 수정폼
  @GetMapping("/items/{id}/edit")
  public String updateItemForm(@PathVariable Long id, Model model) {
    Product product = productService.findId(id);

    ProductForm form = new ProductForm();
    form.setId(product.getId());
    form.setPrice(product.getPrice());
    form.setDiscount(product.getDiscount());
    form.setRating(product.getRating());
    form.setName(product.getName());
    form.setThumbnail(product.getThumbnail());
    form.setDescription(product.getDescription());
    form.setCategory(product.getCategory());
    form.setBrand(product.getBrand());

    model.addAttribute("form", form);
    return "items/updateItemForm";
  }

  //상품 수정 : 가격, 할인금액, 구매자 평점을 수정한다.
  @PostMapping("/items/{id}/edit")
  public String updateItem(@PathVariable Long id, @ModelAttribute("form") ProductForm form) {
    productService.updateItem(id, form.getPrice(), form.getDiscount(), form.getRating());
    return "redirect:/items";
  }

  //상품 삭제
  @GetMapping("/items/delete/{id}")
  public String deleteItem(@PathVariable Long id) {
    productService.deleteProduct(id);
    return "redirect:/items";
  }

}

