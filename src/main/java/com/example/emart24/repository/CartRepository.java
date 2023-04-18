package com.example.emart24.repository;

import com.example.emart24.domain.Cart;
import com.example.emart24.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

//@Repository
@RequiredArgsConstructor
public class CartRepository {
  private final EntityManager em;

  public List<Cart> getAllCartList(Long id) {
    return em.createQuery("select c from Cart c where c.user.id=:id", Cart.class)
        .setParameter("id", id)
        .getResultList();
  }

  public Cart save(Cart cart) {
    em.persist(cart);
    return cart;
  }

  public Cart getCartById(Long id) {
    return em.find(Cart.class, id);
  }

  public void deleteCart(Long id) {
    em.remove(getCartById(id));
  }
}
