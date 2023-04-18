package com.example.emart24.controller.admin;

import lombok.Data;

import java.sql.Date;

@Data
public class EventForm {
  private Long id;
  private String name;
  private Date startDate;
  private Date endDate;
}
