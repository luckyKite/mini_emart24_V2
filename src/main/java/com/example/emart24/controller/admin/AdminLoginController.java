package com.example.emart24.controller.admin;

import com.example.emart24.domain.Role;
import com.example.emart24.domain.User;
import com.example.emart24.dto.LoginDTO;
import com.example.emart24.service.UserService;
import com.example.emart24.session.AdminSession;
import com.example.emart24.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminLoginController {
  private final UserService userService;

  @GetMapping("")
  public String adminHome(){
    // 만약 로그인된 상태라면, index가 로그인 폼이 아닐껄? -> loginHome.html 보여주기ㅋㅋ
    return "index";
  }

  //로그인
  @PostMapping("/login")
  public String sessionLogin(@Validated @ModelAttribute LoginDTO form,
                             @RequestParam(defaultValue = "/") String redirectURL,
                             BindingResult result,
                             HttpServletRequest request){

    if (result.hasErrors()){
      return "index";
    }
    User loginMember = userService.getLogin(form.getEmail(), form.getPassword());

    if(loginMember == null || !loginMember.getRole().equals(Role.관리자)){
      result.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
      return "index";
    }

    //관리자로그인 성공처리
    AdminSession memberSession = new AdminSession();
    memberSession.setId(loginMember.getId());
    memberSession.setLoginId(loginMember.getEmail());
    memberSession.setUsername(loginMember.getPassword());

    HttpSession session = request.getSession(true);// 세션이 있으면 있는 세션을 반환, 없으면 생성해서 반환
    session.setAttribute(SessionConst.ADMIN_SESSION, memberSession);

    return "admin/loginHome";
  }

  //로그아웃
  @GetMapping("/logout")
  public String logout(HttpServletRequest request) {
    HttpSession session = request.getSession(false); //있으면 있는 것 반환, 없으면 null 반환
    if (session != null) {
      session.invalidate();
    }
    return "redirect:/";
  }
}
