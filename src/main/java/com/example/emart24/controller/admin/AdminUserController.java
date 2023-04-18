package com.example.emart24.controller.admin;

import com.example.emart24.domain.OrderItem;
import com.example.emart24.domain.Orders;
import com.example.emart24.domain.User;
import com.example.emart24.dto.AdminOrderDetailDTO;
import com.example.emart24.service.OrderService;
import com.example.emart24.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminUserController {

  private final UserService userService;

  private final OrderService orderService;

  //회원목록 불러오기 (관리자가 회원정보 확인할 수 있음)
  @GetMapping("/members")
  public String memberList(Model model) {
    List<User> members = userService.getUserList();
    model.addAttribute("members", members);
    return "members/memberList";
  }

  //회원 주문목록 확인하기  --------
  @GetMapping("/orders")
  public String orderList(Model model) {
    List<AdminOrderDetailDTO> aodDTO = orderService.getOrderDetail();
    System.out.println(aodDTO);
    model.addAttribute("ordersList", aodDTO);
    return "order/orderList";
  }
}
