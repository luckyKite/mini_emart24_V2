package com.example.emart24.controller;

import com.example.emart24.domain.Event;
import com.example.emart24.domain.EventProduct;
import com.example.emart24.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {
  private final EventService eventService;

  //이벤트 상품 전체 조회
  @GetMapping("/all")
  public List<Event> getAll() {
    return eventService.getAll();
  }

  //이벤트 번호로 해당 이벤트 상품 조회하기
  @GetMapping("/{id}")
  public List<EventProduct> getProductsByEventId(@PathVariable Long id) {
    return eventService.getProductsByEventId(id);
  }

}
