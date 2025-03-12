package com.whj.ldap;

import javax.naming.*;
import javax.naming.directory.*;
import java.util.*;
import javax.net.ssl.*;

import javax.naming.*;
import javax.naming.directory.*;
import java.util.*;

public class LdapExample {

    public static void main(String[] args) {
        // LDAP服务器配置
        String ldapServer = "ldaps://ldap.qunhequnhe.com:636"; // 使用 ldaps:// 协议
        String userDN = "uid=robot-staff-sync,ou=people,dc=qunhequnhe,dc=com"; // 认证用户名
        String password = "55SY38eas6abLl"; // 认证密码
        String baseDN = "ou=people,dc=qunhequnhe,dc=com"; // 查询的Base DN

        // LDAP连接环境设置
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapServer);
        env.put(Context.SECURITY_PRINCIPAL, userDN); // 用户名
        env.put(Context.SECURITY_CREDENTIALS, password); // 密码
        env.put(Context.SECURITY_AUTHENTICATION, "simple"); // 使用简单认证
        env.put("java.naming.ldap.version", "3"); // LDAP协议版本3

        // 查询过滤器和属性
        String searchFilter = "(objectClass=*)"; // 查找所有对象
        String[] requiredAttributes = {"cn", "mail", "displayName"}; // 需要返回的属性

        try {
            // 创建LDAP连接
            DirContext ctx = new InitialDirContext(env);

            // 构建搜索控件
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE); // 搜索子树
            searchControls.setReturningAttributes(requiredAttributes); // 只获取特定属性

            // 执行LDAP查询
            NamingEnumeration<SearchResult> results = ctx.search(baseDN, searchFilter, searchControls);

            // 输出查询结果
            while (results.hasMore()) {
                SearchResult result = results.next();
                Attributes attributes = result.getAttributes();
                System.out.println(attributes);
                System.out.println(attributes.get("cn") + "," + attributes.get("mail") + "," + attributes.get("displayName"));
            }

            // 关闭LDAP连接
            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
