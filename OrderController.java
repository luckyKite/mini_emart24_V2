package com.example.emart24.controller;

import com.example.emart24.domain.OrderItem;
import com.example.emart24.domain.Orders;
import com.example.emart24.dto.OrderDTO;
import com.example.emart24.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

  private final OrderService orderService;

  //주문 조회하기 (해당 아이디의 주문 전체를 가져온다.)
  @GetMapping("/all")
  public List<OrderItem> getOrderList(@RequestParam Long id) {
    return orderService.getOrderList(id);
  }

  //주문하기
  @PostMapping("/add")
  public OrderItem addOrder(@RequestBody OrderDTO orderDTO) {
    return orderService.addOrder(orderDTO);
  }


}
