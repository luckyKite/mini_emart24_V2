package com.example.emart24.repository;

import com.example.emart24.domain.OrderItem;
import com.example.emart24.domain.Orders;
import com.example.emart24.dto.AdminOrderDetailDTO;
import com.example.emart24.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@RequiredArgsConstructor
public class OrderRepository {
  private final EntityManager em;

  public Long save(Orders order) {
    em.persist(order);
    return order.getId();
  }

  public OrderItem save(OrderItem orderItem) {
    em.persist(orderItem);
    return orderItem;
  }

  public List<OrderItem> getOrderList(Long id) {
    return em.createQuery("select oi from Orders o join OrderItem oi on oi.order.id = o.id where o.user.id=:id", OrderItem.class)
        .setParameter("id", id)
        .getResultList();
  }

  public Orders getOrderById(Long orderId) {
    return em.find(Orders.class, orderId);
  }

  //관리자 - OrderItem 주문상태, 회원명
  public List<Orders> findAllByString(OrderItem orderItem) {

    String jpql = "select o from Orders o join o.user m";

    boolean isFirstCondition = true;

    //주문 상태 검색
    if (orderItem.getState() != null) {
      if (isFirstCondition) {
        jpql += " where";
        isFirstCondition = false;
      } else {
        jpql += " and";
      }
      jpql += " o.state = :state";
    }

    //회원 이름 검색
    if (StringUtils.hasText(orderItem.getOrder().getUser().getName())) {
      if (isFirstCondition) {
        jpql += " where";
        isFirstCondition = false;
      } else {
        jpql += " and";
      }
      jpql += " m.name like :name";
    }

    TypedQuery<Orders> query = em.createQuery(jpql, Orders.class)
        .setMaxResults(1000);

    if (orderItem.getState() != null) {
      query = query.setParameter("state", orderItem.getState());
    }
    if (StringUtils.hasText(orderItem.getOrder().getUser().getName())) {
      query = query.setParameter("name", orderItem.getOrder().getUser().getName());
    }

    return query.getResultList();
  }

  public List<AdminOrderDetailDTO> getOrderDetail() {
    return em.createQuery("select new com.example.emart24.dto.AdminOrderDetailDTO(o.user, p.name, oi.qty, p.price, oi.state) from Product p join OrderItem oi on p.id = oi.product.id join Orders o on o.id = oi.order.id", AdminOrderDetailDTO.class)
        .getResultList();
  }

}
