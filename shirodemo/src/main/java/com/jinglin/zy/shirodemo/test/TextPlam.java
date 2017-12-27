package com.jinglin.zy.shirodemo.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class TextPlam {

	public static void main(String[] args) {
		 // ��ȡ�����ļ�����ʼ��SecurityManager����
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // ��ȡsecurityManagerʵ��(��ȫ����
        SecurityManager securityManager = factory.getInstance();
       
       
        // ��securityManagerʵ���󶨵�SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        // ����token���ƣ��û���/����
        UsernamePasswordToken token = new UsernamePasswordToken("zy", "1234");
        // �õ���ǰִ�е��û�
        Subject currentUser = SecurityUtils.getSubject();
        try{
            // �����֤
            currentUser.login(token);   
            System.out.println("�����֤�ɹ���");
        }catch(AuthenticationException e){
            e.printStackTrace();
            System.out.println("�����֤ʧ�ܣ�");
        }
        // �˳�
        currentUser.logout();
	}

}
