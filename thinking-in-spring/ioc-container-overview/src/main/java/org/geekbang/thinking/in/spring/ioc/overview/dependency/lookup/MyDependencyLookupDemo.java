package org.geekbang.thinking.in.spring.ioc.overview.dependency.lookup;

import org.geekbang.thinking.in.spring.ioc.overview.annotation.MySuper;
import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.geekbang.thinking.in.spring.ioc.overview.repository.MyUserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @program: thinking-in-spring
 * @description: 依赖查找Demo, 1.根据名称查找
 * @author: PengLei
 * @created: 2021/05/06 11:26
 */
public class MyDependencyLookupDemo {
    public static void main(String[] args) {
        //启动Spring应用上下文
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/my-dependency-lookup-context.xml");
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/my-dependency-injection-context.xml");
        //实时查找
        lookupInRealTime(beanFactory);
        //延时查找
        lookupInLazy(beanFactory);
        //按照类型查找
        lookupByType(beanFactory);
        //按照类型查找集合对象
        lookupByCollectionByType(beanFactory);
        //通过注解查找对象
        lookupByAnnotationType(beanFactory);
        System.out.println("------------------------------分割线--------------------------------");
        lookupByType(beanFactory);
    }

    /**
     * 通过注解查找对象
     * @param beanFactory 上下文
     */
    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof  ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, Object> beansWithAnnotation = listableBeanFactory.getBeansWithAnnotation(MySuper.class);
            System.out.println("查找标注 @MySuper 所有的 User 集合对象:" + beansWithAnnotation);
        }
    }

    /**
     * 实时查找,集合查找
     * @param beanFactory 上下文
     */
    private static void lookupByCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有 User 对象集合: " + users);
        }
    }

    /**
     * 实时查找,根据Bean名称+类型查找
     * @param beanFactory 上下文
     */
    private static void lookupByType(BeanFactory beanFactory) {
        MyUserRepository userRepository = beanFactory.getBean("userRepository", MyUserRepository.class);
        System.out.println("实时查找(名称+类型):" + userRepository);
    }

    /**
     * 延时查找,根据名称查找
     * @param beanFactory 上下文
     */
    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>)beanFactory.getBean("beanFactory");
        User user = objectFactory.getObject();
        System.out.println("延时查找(名称):" + user);
    }

    /**
     * 实时查找,根据名称查找
     * @param beanFactory 上下文
     */
    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user_pl");
        System.out.println("实时查找(名称):" + user);
    }
}
