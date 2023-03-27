package com.example.emart24.controller.admin;

import com.example.emart24.domain.OrderItem;
import com.example.emart24.domain.Orders;
import com.example.emart24.domain.Product;
import com.example.emart24.domain.User;
import com.example.emart24.service.OrderService;
import com.example.emart24.service.ProductService;
import com.example.emart24.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminItemController {
  private final ProductService productService;

  private final UserService userService;

  private final OrderService orderService;

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
    form.setPrice(form.getPrice());
    form.setDiscount(form.getDiscount());
    form.setRating(form.getRating());
    form.setName(form.getName());
    form.setThumbnail(form.getThumbnail());
    form.setDescription(form.getDescription());
    form.setCategory(form.getCategory());
    form.setBrand(form.getBrand());

    model.addAttribute("form", form);
    return "items/updateItemForm";
  }

  //상품 수정 --수정안돼고 새로 등록됨....
  @PostMapping("/items/{id}/edit")
  public String updateItem(@PathVariable Long id, @ModelAttribute("form") ProductForm form) {
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
    return "redirect:items";
  }

  //상품등록 삭제 ---어떻게???

  //회원목록 불러오기 (관리자가 회원정보 확인할 수 있음)
  @GetMapping("/members")
  public String memberList(Model model) {
    List<User> members = userService.getUserList();
    model.addAttribute("members", members);
    return "members/memberList";
  }

  //회원 주문목록 확인하기  --------안됨ㅠㅠ
  @GetMapping("/orders")
  public String orderList(@ModelAttribute("orderItem") OrderItem orderItem, Model model) {
    List<Orders> orders = orderService.findOrders(orderItem);
    model.addAttribute("orders", orders);
    return "orders/orderList";
  }
}

