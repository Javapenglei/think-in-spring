package org.geekbang.thinking.in.spring.ioc.overview.dependency.injection;

import org.geekbang.thinking.in.spring.ioc.overview.annotation.MySuper;
import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @program: thinking-in-spring
 * @description: 依赖注入demo
 * @author: PengLei
 * @created: 2021/05/06 11:26
 */
public class MyDependencyInjectionDemo {
    public static void main(String[] args) {
        //启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/my-dependency-injection-context.xml");
    }
}
