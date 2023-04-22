package com.example.emart24.service;

import com.example.emart24.domain.OrderItem;
import com.example.emart24.domain.Orders;
import com.example.emart24.domain.State;
import com.example.emart24.dto.AdminOrderDetailDTO;
import com.example.emart24.dto.OrderDTO;
import com.example.emart24.repository.CartRepository;
import com.example.emart24.repository.OrderRepository;
import com.example.emart24.repository.ProductRepository;
import com.example.emart24.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
  private final OrderRepository orderRepository;
  private final UserRepository userRepository;
  private final ProductRepository productRepository;

  private final CartRepository cartRepository;

  @Transactional
  public List<OrderItem> getOrderList(Long id) {
    return orderRepository.getOrderList(id);
  }

  @Transactional
  public OrderItem addOrder(OrderDTO orderDTO) {
    Orders order = new Orders();
    order.setDate(LocalDateTime.now());
    order.setUser(userRepository.getUserById(orderDTO.getUserId()).get());
    Long orderId = orderRepository.save(order);

    OrderItem orderItem = new OrderItem();
    orderItem.setState(State.주문완료);
    orderItem.setOrder(orderRepository.getOrderById(orderId));
    orderItem.setProduct(productRepository.findId(orderDTO.getProductId()));
    orderItem.setQty(orderDTO.getQty());

    if(orderDTO.getCartId() != null) {
      Long cartId = orderDTO.getCartId();
      cartRepository.deleteCart(cartId);
    }

    return orderRepository.save(orderItem);
  }

  //검색
  public List<Orders> findOrders(OrderItem orderItem) {
    return orderRepository.findAllByString(orderItem);
  }

  public List<AdminOrderDetailDTO> getOrderDetail() {
    return orderRepository.getOrderDetail();
  }

//  public List<AdminOrderDetailDTO> getOrderDetailByUserId(Long userId) {
//    return orderRepository.getOrderDetailByUserId(userId);
//  }
}
