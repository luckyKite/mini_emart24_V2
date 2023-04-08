package com.example.emart24.interceptor;

import com.example.emart24.session.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Slf4j
public class AdminCheckInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HttpSession session = request.getSession(false);
    if (session != null && session.getAttribute(SessionConst.ADMIN_SESSION) != null) {
      log.info("관리자의 요청, {}", request.getRequestURI());
      return true;
    } else {
      log.info("오면 안되는 요청, {}", request.getRequestURI());
      return false;
    }
  }
}
