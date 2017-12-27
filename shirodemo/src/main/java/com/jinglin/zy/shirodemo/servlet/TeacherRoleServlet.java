package com.jinglin.zy.shirodemo.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;

import org.apache.shiro.subject.Subject;

public class TeacherRoleServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("role deget");
        Subject currentUser = SecurityUtils.getSubject();
        //��ʵ�ǲ����ж��ˣ���ΪֻҪ�����ˣ��϶���ɫ�ǶԵģ����������
        //�жϵ�ǰ�û��Ƿ����teacher��ɫ
        if(currentUser.hasRole("teacher")||currentUser.hasRole("admin")) {
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } else {            
            request.getRequestDispatcher("/unauthorized.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}