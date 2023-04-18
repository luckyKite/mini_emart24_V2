package com.example.emart24.service;

import com.example.emart24.domain.Cart;
import com.example.emart24.domain.Product;
import com.example.emart24.dto.CartDTO;
import com.example.emart24.repository.CartRepository;
import com.example.emart24.repository.ProductRepository;
import com.example.emart24.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CartService {
  private final CartRepository cartRepository;
  private final UserRepository userRepository;
  private final ProductRepository productRepository;

  public List<Cart> getAllCartList(Long id) {
    return cartRepository.getAllCartList(id);
  }

  @Transactional
  public Cart addCart(CartDTO cartDTO) {
    Optional<Cart> sameProduct = userRepository.getSameProduct(cartDTO);
    Cart cart;
    if(sameProduct.isEmpty()) {
      cart = new Cart();
      cart.setQty(cartDTO.getQty());
      cart.setUser(userRepository.getUserById(cartDTO.getUserId()).get());
      cart.setProduct(productRepository.findId(cartDTO.getProductId()));
    } else {
      cart = sameProduct.get();
      cart.setQty(cart.getQty() + 1L);
    }
    return cartRepository.save(cart);
  }

  @Transactional
  public Cart changeQty(Long qty, Long id) {
    Cart cart = cartRepository.getCartById(id); //장바구니번호로 장바구니 조회
    if(cart.getQty() + qty <= 0) {
      cart.setQty(1L);
    } else {
      cart.setQty(cart.getQty() + qty);
    }
    return cart;
  }

  @Transactional
  public void deleteCart(Long id) {
    cartRepository.deleteCart(id);
  }


}
