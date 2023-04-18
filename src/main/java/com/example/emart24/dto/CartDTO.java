package com.example.emart24.dto;

import lombok.Data;

@Data
public class CartDTO {
  Long productId;
  Long userId;
  Long qty;
}