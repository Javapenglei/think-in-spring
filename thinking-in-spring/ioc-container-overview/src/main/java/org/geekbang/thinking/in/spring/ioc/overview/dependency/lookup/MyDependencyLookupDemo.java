package org.geekbang.thinking.in.spring.ioc.overview.dependency.lookup;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: thinking-in-spring
 * @description: 依赖查找Demo
 * @author: PengLei
 * @created: 2021/05/06 11:26
 */
public class MyDependencyLookupDemo {
    public static void main(String[] args) {
        //启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/my-dependency-lookup-context.xml");
        User user = (User) beanFactory.getBean("user");
        System.out.println(user);
    }
}
