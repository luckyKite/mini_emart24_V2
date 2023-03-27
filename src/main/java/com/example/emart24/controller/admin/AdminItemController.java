package com.example.emart24.controller.admin;

import com.example.emart24.domain.Product;
import com.example.emart24.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AdminItemController {
  private final ProductService productService;

  @GetMapping("/items/new")
  public String createForm(Model model) {
    model.addAttribute("form", new ItemForm());
    return "items/createItemForm";
  }

  //상품등록 폼에 저장할 목록
  @PostMapping("/items/new")
  public String createForm(ItemForm form) {
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
}

