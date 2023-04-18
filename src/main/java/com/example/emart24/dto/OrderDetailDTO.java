package com.example.emart24.dto;

import com.example.emart24.domain.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
public class OrderDetailDTO {
  public OrderDetailDTO(User user, String productName, Long qty, int price, State state) {
    this.user = user;
    this.productName = productName;
    this.qty = qty;
    this.price = price;
    this.state = state;
  }

  private User user;
  private String productName;
  private Long qty;
  private int price;
  private State state;
}
