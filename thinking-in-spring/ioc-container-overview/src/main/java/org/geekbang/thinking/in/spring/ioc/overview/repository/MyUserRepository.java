package org.geekbang.thinking.in.spring.ioc.overview.repository;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;

import java.util.Collection;

/**
 * @program: thinking-in-spring
 * @description: 用户信息仓库
 * @author: PengLei
 * @created: 2021/05/08 09:52
 */
public class MyUserRepository {

    private Collection<User> users;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "MyUserRepository{" +
                "users=" + users +
                '}';
    }
}
