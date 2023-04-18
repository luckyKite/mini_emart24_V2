package com.example.emart24.repository;

import com.example.emart24.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

//@Repository
@RequiredArgsConstructor
public class ProductRepository {
  private final EntityManager em;

  public List<Product> getAll() {
    return em.createQuery("select p from Product p", Product.class).getResultList();
  }

  public Product findId(Long id) {
    return em.find(Product.class, id);
  }

  public List<Product> getSearchList(String q) {
    return em.createQuery("select p from Product p where p.name like:name", Product.class)
        .setParameter("name", "%" + q + "%")
        .getResultList();
  }

  //관리자 - 상품 등록하기
  public void save(Product product) {
    if (product.getId() == null) {
      em.persist(product);
    } else {
      em.merge(product);
    }
  }

  //관리자 - 상품 삭제하기
  public void deleteProduct(Long id) {
    Product prod = findId(id);
    System.out.println(prod);
    em.remove(prod);
  }
}
