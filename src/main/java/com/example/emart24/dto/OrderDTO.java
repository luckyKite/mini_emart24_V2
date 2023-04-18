package com.example.emart24.dto;

import com.example.emart24.domain.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDTO {
  Long cartId;
  Long userId;
  Long productId;
  Long qty;
}
