package com.example.emart24.controller.admin;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductForm {
  private Long id;

  private int price;
  private double discount;
  private double rating;
  private String name;
  private String thumbnail;
  private String description;
  private String category;
  private String brand;

}
