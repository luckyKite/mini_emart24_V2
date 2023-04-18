package com.example.emart24.service;

import com.example.emart24.domain.Role;
import com.example.emart24.domain.User;
import com.example.emart24.dto.OrderDetailDTO;
import com.example.emart24.dto.UserDTO;
import com.example.emart24.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public List<User> getUserList() {
    return userRepository.getUserList();
  }

  @Transactional
  public User joinUser(UserDTO userDTO) {
    User user = new User();
    user.setName(userDTO.getName());
    user.setEmail(userDTO.getEmail());
    user.setPassword(userDTO.getPassword());
    user.setAddress(userDTO.getAddress());
    user.setRole(Role.일반회원);
    userRepository.save(user);
    return user;
  }

  public User getUserById(Long id) {
    return userRepository.getUserById(id).orElse(null);
  }

  @Transactional
  public User changeUserInfo(User user, Long id) {
    User changeUser = userRepository.getUserById(id).orElse(null);
    assert changeUser != null;
    changeUser.setPassword(user.getPassword());
    changeUser.setAddress(user.getAddress());
    userRepository.save(changeUser);
    return changeUser;
  }

  public User getUserByEmail(String email) {
    return userRepository.getUserByEmail(email).orElse(new User());
  }

  public User getLogin(String email, String password) {
    return userRepository.getLogin(email, password).orElse(new User());
  }

  @Transactional
  public List<OrderDetailDTO> getOrderDetailByUserId(Long userId) {
    return userRepository.getOrderDetailByUserId(userId);
  }

}
