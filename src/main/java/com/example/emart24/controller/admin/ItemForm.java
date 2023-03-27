package com.example.emart24.controller.admin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ItemForm {
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
