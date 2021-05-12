package org.geekbang.thinking.in.spring.ioc.overview.container;
import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.geekbang.thinking.in.spring.ioc.overview.enums.City;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @program: thinking-in-spring
 * 注解能力{@link ApplicationContext} 作为 IoC容器示例
 * @author: PengLei
 * @created: 2021/05/11 17:13
 */
@Configuration
public class MyAnnotationApplicationContextAsIocContainerDemo {

   public static void main(String[] args){
       //创建BeanFactory容器
       AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
       //将当前类MyAnnotationApplicationContextAsIocContainerDemo作为配置类(Configuration Class)
       applicationContext.register(MyAnnotationApplicationContextAsIocContainerDemo.class);
       //启动
       applicationContext.refresh();
       lookupByCollectionByType(applicationContext);
   }

   @Bean
   public User user(){
       User user = new User();
       user.setCity(City.BEIJING);
       user.setId(1L);
       user.setName("彭磊");
       return user;
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

}
