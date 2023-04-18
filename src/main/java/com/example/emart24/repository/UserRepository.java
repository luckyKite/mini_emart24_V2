package com.example.emart24.repository;

import com.example.emart24.domain.Cart;
import com.example.emart24.domain.User;
import com.example.emart24.dto.CartDTO;
import com.example.emart24.dto.OrderDetailDTO;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

//@Repository
@RequiredArgsConstructor
public class UserRepository {
  private final EntityManager em;


  public List<User> getUserList() {
    return em.createQuery("select u from User u", User.class).getResultList();
  }

  public void save(User user) {
    em.persist(user);
  }

  public Optional<User> getUserById(Long id) {
    return Optional.ofNullable(em.find(User.class, id));
  }

  public Optional<Cart> getSameProduct(CartDTO cartDTO) {
    return em.createQuery("select c from Cart c where c.product.id=:productId and c.user.id=:userId", Cart.class)
        .setParameter("productId", cartDTO.getProductId() )
        .setParameter("userId", cartDTO.getUserId())
        .getResultStream().findAny();
  }

  public Optional<User> getUserByEmail(String email) {
    return em.createQuery("select u from User u where u.email=:email", User.class)
        .setParameter("email", email)
        .getResultList()
        .stream().findAny();
  }

  public Optional<User> getLogin(String email, String password) {
    return em.createQuery("select u from User u where u.email=:email and u.password=:password", User.class)
        .setParameter("email", email)
        .setParameter("password", password)
        .getResultList()
        .stream().findAny();
  }

  public List<OrderDetailDTO> getOrderDetailByUserId(Long userId) {
    return em.createQuery("select new com.example.emart24.dto.OrderDetailDTO(o.user, p.name, oi.qty, p.price, oi.state) from Product p join OrderItem oi on p.id = oi.product.id join Orders o on o.id = oi.order.id where o.user.id=:userId", OrderDetailDTO.class)
        .setParameter("userId", userId).getResultList();
  }

}
