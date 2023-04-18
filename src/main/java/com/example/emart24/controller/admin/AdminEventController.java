package com.example.emart24.controller.admin;

import com.example.emart24.domain.Event;
import com.example.emart24.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminEventController {

  private final EventService eventService;

  //이벤트 등록
  @GetMapping("/events/new")
  public String createEventForm(Model model) {
    model.addAttribute("form", new EventForm());
    return "event/createEventForm";
  }

  //이벤트 저장
  @PostMapping("/events/new")
  public String createEventForm(EventForm form) {
    Event event = new Event();
    event.setName(form.getName());
    event.setStartDate(form.getStartDate());
    event.setEndDate(form.getEndDate());

    eventService.saveEvent(event);
    return "redirect:/eventsList";
  }

  //이벤트 목록 확인하기
  @GetMapping("/eventsList")
  public String list(Model model) {
    List<Event> allEvents = eventService.getAll();
    model.addAttribute("allEvents", allEvents);
    return "event/eventsList";
  }

  //이벤트 수정하기
  @GetMapping("/events/{id}/edit")
  public String updateEventForm(@PathVariable Long id, Model model) {
    Event event = eventService.findEvent(id);

    EventForm form = new EventForm();
    form.setId(event.getId());
    form.setName(event.getName());
    form.setStartDate(event.getStartDate());
    form.setEndDate(event.getEndDate());

    model.addAttribute("form", form);
    return "event/updateEventForm";
  }

  @PostMapping("/events/{id}/edit")
  public String updateEvent(@PathVariable Long id, @ModelAttribute("form") EventForm form) {
    eventService.updateEvent(id, form.getName(), form.getStartDate(), form.getEndDate());
    return "redirect:/eventsList";
  }

  //이벤트 삭제
  @GetMapping("/events/delete/{id}")
  public String deleteEvent(@PathVariable Long id) {
    eventService.deleteEvent(id);
    return "redirect:/eventsList";
  }
}
