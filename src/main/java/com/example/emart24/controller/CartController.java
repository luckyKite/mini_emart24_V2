package com.example.emart24.controller;

import com.example.emart24.domain.Cart;
import com.example.emart24.domain.Product;
import com.example.emart24.dto.CartDTO;
import com.example.emart24.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class CartController {
  private final CartService cartService;

  //내가 담은 장바구니 목록 전체 불러오기
  @GetMapping("/all")
  public List<Cart> getAllCartList(@RequestParam Long id) {
    return cartService.getAllCartList(id);
  }

  //장바구니에 선택한 상품 담기
  @PostMapping("/add")
  public Cart addCart(@RequestBody CartDTO cartDTO) {
    //log.info("Cart" + cartDTO);
    return cartService.addCart(cartDTO);
  }

  //사용자의 장바구니에서 수량 업데이트
  @PutMapping("/update/{id}")
  public Cart updateCart(@RequestBody CartDTO cartDTO, @PathVariable Long id) {
    return cartService.changeQty(cartDTO.getQty(), id);
  }

  //사용자의 장바구니에서 상품 삭제
  @DeleteMapping("/delete/{id}")
  public void deleteCart(@PathVariable Long id) {
    cartService.deleteCart(id);
  }

}
