package com.jinglin.zy.shirodemo.test;

import java.util.Arrays;

import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.jinglin.zy.shirodemo.util.ShiroUtil;

public class RoleTest {

	@Test
    public void testHasRole() {

        String configFile = "classpath:shiro.ini";
        String username = "zy";
        String password = "123";
        Subject currentUser = ShiroUtil.login(configFile, username, password);
        
        System.out.println(currentUser.hasRole("role1")? "��role1�����ɫ" : "û��role1�����ɫ");
        //����hasRole
        System.out.println(currentUser.hasRole("role2")? "��role2�����ɫ" : "û��role2�����ɫ");

        //����hasRoles
        boolean[] results = currentUser.hasRoles(Arrays.asList("role1","role2","role3"));
        System.out.println(results[0]? "��role1�����ɫ" : "û��role1�����ɫ");
        System.out.println(results[1]? "��role2�����ɫ" : "û��role2�����ɫ");
        System.out.println(results[2]? "��role3�����ɫ" : "û��role3�����ɫ");

        //����hasAllRoles     System.out.println(currentUser.hasAllRoles(Arrays.asList("role1","role2","role3")));

        currentUser.logout();
    }
}
