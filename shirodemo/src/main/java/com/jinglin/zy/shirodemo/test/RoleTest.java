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
        
        System.out.println(currentUser.hasRole("role1")? "有role1这个角色" : "没有role1这个角色");
        //测试hasRole
        System.out.println(currentUser.hasRole("role2")? "有role2这个角色" : "没有role2这个角色");

        //测试hasRoles
        boolean[] results = currentUser.hasRoles(Arrays.asList("role1","role2","role3"));
        System.out.println(results[0]? "有role1这个角色" : "没有role1这个角色");
        System.out.println(results[1]? "有role2这个角色" : "没有role2这个角色");
        System.out.println(results[2]? "有role3这个角色" : "没有role3这个角色");

        //测试hasAllRoles     System.out.println(currentUser.hasAllRoles(Arrays.asList("role1","role2","role3")));

        currentUser.logout();
    }
}
