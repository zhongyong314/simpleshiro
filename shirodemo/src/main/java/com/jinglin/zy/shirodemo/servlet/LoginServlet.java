package com.jinglin.zy.shirodemo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

//LoginServlet.java
public class LoginServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      System.out.println("login doGet");
      String username = request.getParameter("username");
      String password = request.getParameter("password");

      Subject currentUser = SecurityUtils.getSubject();
      UsernamePasswordToken token = new UsernamePasswordToken(username, password);
      try {
          currentUser.login(token);
          System.out.println("��֤�ɹ�");
          request.getSession().setAttribute("username", username);
          request.getRequestDispatcher("/success.jsp").forward(request, response);
      } catch (AuthenticationException e) {
          e.printStackTrace();
          System.out.println("��֤ʧ��");
          request.getRequestDispatcher("/login.jsp").forward(request, response);
      }
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

      doGet(request, response);
  }
}
