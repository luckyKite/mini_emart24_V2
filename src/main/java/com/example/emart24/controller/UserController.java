package com.example.emart24.controller;

import com.example.emart24.domain.User;
import com.example.emart24.dto.AdminOrderDetailDTO;
import com.example.emart24.dto.OrderDetailDTO;
import com.example.emart24.dto.UserDTO;
import com.example.emart24.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  //전체 회원 리스트를 불러온다.
  @GetMapping("/list")
  public List<User> getUserList() {
    return userService.getUserList();
  }

  //회원가입 기능
  @PostMapping("/join")
  public User joinUser(@RequestBody UserDTO userDTO) {
    //log.info("user = " + user);
    return userService.joinUser(userDTO);
  }

  //특정 회원 조회하기
  @GetMapping("/{id}")
  public User getUserById(@PathVariable Long id) {
    return userService.getUserById(id);
  }

  //회원정보(비밀번호, 주소) 변경하기
  @PutMapping("/{id}")
  public User changeUserInfo(@RequestBody User user, @PathVariable Long id) {
    return userService.changeUserInfo(user, id);
  }

  //이메일로 회원 조회
  @GetMapping("/email")
  public User getUserEmail(@RequestParam @PathVariable String email) {
    return userService.getUserByEmail(email);
  }

  //로그인
  @GetMapping("/login")
  public User getLogin(@RequestParam String email, @RequestParam String password) {
    return userService.getLogin(email, password);
  }

  //회원 목록 조회
  @GetMapping("/orders/{userId}")
  public List<OrderDetailDTO> orderList(@PathVariable Long userId) {
    return userService.getOrderDetailByUserId(userId);
  }
}
