package com.envision.domain;

import java.io.Serializable;

public class Account implements Serializable {

    private Integer id;
    private Integer uid;
    private Double money;

    //一对一！
    //从表实体应该包含一个主表实体的 对象 引用
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                //这里不加user 类似于jsonIgnore的意思 没必要给账户序列号还带着user，而且一般通过用户查出账户，不会给账户实体类中user赋值 没必要
                '}';
    }
}
