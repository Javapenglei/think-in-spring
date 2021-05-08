package org.geekbang.thinking.in.spring.ioc.overview.domain;

import org.geekbang.thinking.in.spring.ioc.overview.annotation.MySuper;

/**
 * @program: thinking-in-spring
 * @description: SuperUser
 * @author: PengLei
 * @created: 2021/05/07 11:30
 */
@MySuper
public class MySuperUser extends User{

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "MySuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
