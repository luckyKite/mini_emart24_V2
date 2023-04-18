package com.example.emart24.repository;

import com.example.emart24.domain.Event;
import com.example.emart24.domain.EventProduct;
import com.example.emart24.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

//@Repository
@RequiredArgsConstructor
public class EventRepository {
  private final EntityManager em;

  public List<Event> getAll() {
    return em.createQuery("select e from Event e", Event.class).getResultList();
  }

  public Event findEvent(Long id) {
    return em.find(Event.class, id);
  }

  public List<EventProduct> getProductsByEventId(Long eventId) {
    return em.createQuery("select ep from Event e join EventProduct ep on e.id = ep.event.id where e.id=:eventId", EventProduct.class)
        .setParameter("eventId", eventId)
        .getResultList();
  }

  //관리자 - 이벤트 등록하기
  public void save(Event event) {
    if(event.getId() == null) {
      em.persist(event);
    } else {
      em.merge(event);
    }
  }

  //관리자 - 이벤트 삭제하기
  public void deleteEvent(Long id) {
    em.remove(findEvent(id));
  }
}
