package com.example.emart24.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
