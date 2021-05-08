package org.geekbang.thinking.in.spring.ioc.overview.dependency.injection;

import org.geekbang.thinking.in.spring.ioc.overview.annotation.MySuper;
import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.geekbang.thinking.in.spring.ioc.overview.repository.MyUserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

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

        //依赖来源一: 自定义Bean
        MyUserRepository userRepository = beanFactory.getBean("userRepository", MyUserRepository.class);

//        System.out.println(userRepository);

        //依赖来源二: 依赖注入(内建依赖)
        System.out.println(userRepository.getBeanFactory());

        System.out.println(userRepository.getBeanFactory() == beanFactory);

        //依赖查找(错误)
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        System.out.println(userRepository.getObjectFactory().getObject());
        System.out.println(userRepository.getObjectFactory().getObject() == beanFactory);

        //依赖来源三: 容器内建Bean
        Environment environment  = beanFactory.getBean(Environment.class);
        System.out.println("根据类型查找容器内建Bean[Environment]: " + environment);
    }
}
