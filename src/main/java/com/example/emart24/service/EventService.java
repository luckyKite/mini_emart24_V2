package com.example.emart24.service;

import com.example.emart24.controller.admin.EventForm;
import com.example.emart24.domain.Event;
import com.example.emart24.domain.EventProduct;
import com.example.emart24.domain.Product;
import com.example.emart24.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

//@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EventService {
  private final EventRepository eventRepository;

  @Transactional
  public List<Event> getAll() {
    return eventRepository.getAll();
  }

  public List<EventProduct> getProductsByEventId(Long id) {
    return eventRepository.getProductsByEventId(id);
  }

  @Transactional
  public void saveEvent(Event event) {
    eventRepository.save(event);
  }

  public Event findEvent(Long id) {
    return eventRepository.findEvent(id);
  }

  @Transactional
  public void updateEvent(Long eventId, String name, Date startDate, Date endDate) {
    Event event = eventRepository.findEvent(eventId);
    event.setName(name);
    event.setStartDate(startDate);
    event.setEndDate(endDate);
  }

  @Transactional
  public void deleteEvent(Long id) {
    eventRepository.deleteEvent(id);
  }
}
