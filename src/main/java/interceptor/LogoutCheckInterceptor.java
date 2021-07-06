/*
========================================================================
파    일    명 : LogoutCheckInterceptor.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.03
작  성  내  용 : 로그인한 사용자는 비밀번호 찾기 기능 접근 불가
========================================================================
*/
package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import petProject.service.ScriptWriter;
import petProject.vo.AuthInfo;

public class LogoutCheckInterceptor implements HandlerInterceptor {

   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {
      HttpSession session = request.getSession(false);
      if (session != null) {
         AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
         if (authInfo != null) {
            return ScriptWriter.write("로그인 상태입니다.", "home", request, response);
         }
      }

      return true;
   }

}