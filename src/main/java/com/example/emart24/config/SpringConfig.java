package com.example.emart24.config;

import com.example.emart24.repository.*;
import com.example.emart24.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class SpringConfig {
  private final EntityManager em;

  @Bean
  public ProductService productService() {
    return new ProductService(productRepository());
  }

  @Bean
  public ProductRepository productRepository() {
    return new ProductRepository(em);
  }

  @Bean
  public UserService userService() {
    return new UserService(userRepository());
  }

  @Bean
  public UserRepository userRepository() {
    return new UserRepository(em);
  }


  @Bean
  public CartService cartService() {
    return new CartService(cartRepository(), userRepository(), productRepository());
  }

  @Bean
  public CartRepository cartRepository() {
    return new CartRepository(em);
  }

  @Bean
  public EventService eventService() {
    return new EventService(eventRepository());
  }

  @Bean
  public EventRepository eventRepository() {
    return new EventRepository(em);
  }

  @Bean
  public OrderService orderService() {
    return new OrderService(orderRepository(), userRepository(), productRepository(), cartRepository());
  }

  @Bean
  public OrderRepository orderRepository() {
    return new OrderRepository(em);
  }
}
